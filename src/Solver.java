/**
 * This class takes in the matrix from the already used Sudoku dataset, and uses a backtracking algorithm to solve it.
 * It contains a constructor that sets the matrix to be used, and has a solving method aswell as brother methods.
 *
 * This toString method was adapted from a StackOverflow solution which I cannot find.
 * @author Austin FitzGerald
 */

class Solver
{
   private final int size = 9; // The Sudoku grid size, this is a variable incase I want to change to a less common size.
   private final int[][] matrix; // Creation of the 2d array which holds the original values.

   private final int log10 = (int) Math.floor(Math.log10(size * size)) + 1; // Used for the toString
   private final String numberFormat = String.format("%%%dd", log10); // Also used for the toString

   /**
    * This constructor sets the matrix to be used, and calls the solving method.
    * @param matrix This is the previously used matrix as defined in the main class.
    */
   public Solver(int[][] matrix)
   {
      this.matrix = matrix;
      solve(0, 0); // Calling the solve method with base values of 0
   }

   /**
    * This method contains the main backtracking code used to find the solution for the Sudoku stored in a 2d array.
    * It runs through empty cells in order, fills them in randomly, and checks to see if the inputs are allowed.
    *    If they are not, then it does it again and again till it is legal. This is a type of depth-first searching.
    * If you want to learn more about this bruteforcing method, check out https://en.wikipedia.org/wiki/Sudoku_solving_algorithms#Backtracking
    * @param row The base value is 0, but the method changes it through each iteration
    * @param col Same as column, used for each search
    * @return true when found allowed values (If they follow the basic Sudoku rules for numbering in rows/columns/boxes
    */
   private boolean solve(int row, int col)
   {
      if (row == size)
      {
         row = 0;
         if (++ col == size)
            return true;
      }

      if (matrix[row][col] != 0)  // skip filled cells
         return solve(row + 1, col);

      for (int val = 1; val <= size; ++ val)
      {
         if (isLegal(row, col, val)) // Calling the method to check if the inputs are allowed
         {
            matrix[row][col] = val;
            if (solve(row + 1, col))
               return true;
         }
      }
      matrix[row][col] = 0; // reset on backtrack
      return false;
   }

   /**
    * This method checks if all values are legal, based on the basic Sudoku rules.
    * It calls its brother methods to check for rows/columns and boxes.
    * @param row The row to be checked
    * @param col The column to be checked
    * @param val The input value to be checked
    * @return true if legal, false if not
    */
   private boolean isLegal(int row, int col, int val)
   {
      return ! (contains(row, col, val) || containsInBox(row, col, val));
   }

   /**
    * This is a brother method to isLegal, it checks if a value is already used in the row or column.
    * @param row The row to be checked
    * @param col The column to be checked
    * @param val The value to be checked in row and column
    * @return true of already used, false if not
    */
   private boolean contains(int row, int col, int val)
   {
      for (int i = 0; i < size; i++)
      {
         if (matrix[i][col] == val)
            return true;
         if (matrix[row][i] == val)
            return true;
      }
      return false;
   }

   /**
    * This is a brother method to isLegal, it checks if a value is already used in the 3x3 box.
    * @param row The row in which the input is inside
    * @param col The column in which the input value is inside
    * @param val The value to be checked
    * @return true if it is already used, false otherwise
    */
   private boolean containsInBox(int row, int col, int val)
   {
      int r = row - row % 3; // Constraining to the three boxes around the value, in a row
      int c = col - col % 3; // Constraining to the three boxes around the value, in a column
      /*
      Loops through the box containing the 9 values to be checked, returning true if it is already used, false otherwise
       */
      for (int i = r; i < r + 3; i++)
      {
         for (int j = c; j < c + 3; j++)
         {
            if (matrix[i][j] == val)
               return true;
         }

      }
      return false;
   }

   /**
    * This toString method is adapted from a StackOverflow response. It outputs each matrix value into pretty
    *    rows and columns. I have made it look as much like a Sudoku grid as I can.
    * @return The String to be printed
    */
   @Override
   public String toString()
   {
      StringBuffer buff = new StringBuffer(); // Initializing a new String Buffer for the matrix.

      if (matrix != null)
      {
         for (int row = 0; row < size; row++) // For each row, run through this loop
         {
            for (int col = 0; col < size; col++) // For each column, of each row, run through this loop
            {
               /*
               If the value is 0, which means empty, replace it with the placeholder '#'
               If it is not empty, add the formatted digit to the string buffer
                */
               if (matrix[row][col] == 0)
                  buff.append(" #");
               else
                  buff.append(String.format(numberFormat, matrix[row][col]));

               /*
               The first if statement is to keep the last spot of each column from having any formatting
               As long as that is true:
                  If a column should have a box boundry, place one there, but otherwise leave it as a space.
                */
               if (col < size - 1)
               {
                  if ((col == 2 || col == 5))
                     buff.append(" |");
                  else
                     buff.append("  ");
               }
            }

            if (row < size - 1) // Making sure the last spot of each row is empty (formatting)
            {
               buff.append("\n"); // Add a new line to the string buffer for each row
               for (int col = 0; col < size; col++) // Loop through each column
               {
                  /*
                  This adds box boundaries where necessary.
                   */
                  for (int i = 0; i <= log10; i++)
                  {
                     if (row == 2 || row == 5)
                        buff.append("=");
                     else
                        buff.append("-");
                  }
                  if ((col == 2 || col == 5) && (row == 2 || row == 5))
                  {
                     buff.append("+");
                  } else if (row == 2 || row == 5)
                     buff.append("=");
                  else if (col == 2 || col == 5)
                     buff.append("|");
                  else
                     buff.append("-");
               }
               buff.append("\n");
            } else
            {
               buff.append("\n");
            }
         }
      }

      return buff.toString();
   }

}