import java.io.*;

/**
 * This class reads in data from the user-chosen file. It contains a constructor that calls the main method.
 * It also contains a getter for the matrix, and a toString method to nicely output the original Sudoku.
 * <p>
 * This toString method was adapted from a StackOverflow solution which I cannot find.
 *
 * @author Austin FitzGerald
 */

class Reader
{
   private final int size = 9; // The Sudoku grid size, this is a variable incase I want to change to a less common size.
   private final int[][] matrix = new int[size][size]; // Creation of the 2d array which holds the original values.

   private final int log10 = (int) Math.floor(Math.log10(size * size)) + 1; // Used for the toString
   private final String numberFormat = String.format("%%%dd", log10); // Also used for the toString

   /**
    * The constructor, holds a try-catch that calls the readFile method.
    * @param filename This is the user-inputted file name.
    */
   public Reader(String filename)
   {
      try
      {
         readFile(filename);
      } catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   /**
    * This method is a simple getter for returning the puzzle matrix.
    * @return The 2d array holding the original Sudoku puzzle.
    */
   public int[][] getMatrix()
   {
      return this.matrix;
   }

   /**
    * This method reads in the specified text file. It goes through each digit and places it inside of the matrix.
    * @param filename The user-inputted file name.
    * @throws IOException Used in the try-catch of the constructor, in case the file is unreadable/deleted.
    */
   private void readFile(String filename) throws IOException
   {
      File file = new File("src/data/data" + filename + ".txt");
      BufferedReader buffer = new BufferedReader(new FileReader(file));

      /*
      This loops through each line of the file and converts it to a character array.
      Each character is placed into the matrix at the specified row and column.
       */
      for (int i = 0; i < size; i++)
      {
         char[] array = buffer.readLine().toCharArray();

         for (int j = 0; j < size; j++)
         {
            matrix[i][j] = Character.getNumericValue(array[j + (array.length - size)]);
         }
      }
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