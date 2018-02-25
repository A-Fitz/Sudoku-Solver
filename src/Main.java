import java.util.Scanner;

/**
 * This program takes in Sudoku problems, which are stored in text files in a 9x9 array with no formatting besides new lines,
 * and solves them; while displaying them nicely in the console.
 * This class initializes the Sudoku file reader and solver, while taking user input for which Sudoku(s) to solve.
 *
 * @author Austin FitzGerald
 * Datasets used are from http://lipas.uwasa.fi/~timan/sudoku/ and https://github.com/mjzarrin/sodoku/tree/master/src/data
 */

class Main
{
   private static final Scanner stdin = new Scanner(System.in); // Creation of the Scanner used for user inputs
   private static final int MAXFILES = 60; // The maximum number of data files available

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      int dataNum = 0; // Initializing the Sudoku file number variable
      dataNum = readInput(); // Calls the readInput method to prompt for the file number, sets it to the variable

      // Here we check for an out of range inputted value. If it is out of range, display as so and restart the input method.
      if ((dataNum < 1 || dataNum > MAXFILES) && dataNum != 99) // The 99 is an arbitrary value to display all solutions
      {
         System.out.println("Incorrect input. Try again.");
         readInput(); // Re-calling the method
      }

      if (dataNum == 99) // Arbitrary value to call the method that solves all data sets
      {
         doAllDataSets();
      } else
      {
         /*
            Here we create object references for the original puzzles and the solved puzzles.
            We also display their toString methods to display the outputs nicely.
          */
         Reader original = new Reader(String.valueOf(dataNum));
         System.out.println("Your Original Sudoku: ");
         System.out.println(original.toString());

         Solver solved = new Solver(original.getMatrix()); // Creating the Solver object reference with the matrix from the original
         System.out.println("Your Solved Sudoku: ");
         System.out.println(solved.toString());
      }
   }

   /**
    * This method prompts and takes in the user input for which dataset they would like solved.
    * @return If all datasets, it returns 99. Otherwise, return the integer that was entered.
    *    Handle errors in the main method.
    */
   private static int readInput()
   {
      String input = null;
      int dataNum = 0;

      System.out.println("Which dataset to use? Enter 1 to " + MAXFILES + ". Or A for all.");
      input = stdin.nextLine();

      if (input.contains("A") || input.contains("a"))
         return 99;

      dataNum = Integer.parseInt(input);
      return dataNum;
   }

   /**
    * This method loops through each dataset and shows the original puzzle and the solution.
    */
   private static void doAllDataSets()
   {
      for (int i = 1; i <= MAXFILES; i++)
      {
         Reader original = new Reader(String.valueOf(i));
         System.out.println("Original Sudoku #" + i + ": ");
         System.out.println(original.toString());

         Solver solved = new Solver(original.getMatrix());
         System.out.println("Solved Sudoku #" + i + ": ");
         System.out.println(solved.toString());
      }
   }
}
