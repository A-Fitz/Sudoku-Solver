
# Sudoku Solver
This Java program displays and solves Sudoku puzzles using a backtracking algorithim. It has 60 data files of example Sudoku puzzles.

Datasets used are from http://lipas.uwasa.fi/~timan/sudoku/ and https://github.com/mjzarrin/sodoku/tree/master/src/data

### Example Input and Output
> 100000089
> 382070015
> 000000600
> 070064030
> 613020548
> 020510070
> 006000000
> 850090264
> 930000001

    Your Original Sudoku: 
     1   #   # | #   #   # | #   8   9
    -----------|-----------|------------
     3   8   2 | #   7   # | #   1   5
    -----------|-----------|------------
     #   #   # | #   #   # | 6   #   #
    ===========+===========+============
     #   7   # | #   6   4 | #   3   #
    -----------|-----------|------------
     6   1   3 | #   2   # | 5   4   8
    -----------|-----------|------------
     #   2   # | 5   1   # | #   7   #
    ===========+===========+============
     #   #   6 | #   #   # | #   #   #
    -----------|-----------|------------
     8   5   # | #   9   # | 2   6   4
    -----------|-----------|------------
     9   3   # | #   #   # | #   #   1
    
    Your Solved Sudoku: 
     1   6   4 | 2   3   5 | 7   8   9
    -----------|-----------|------------
     3   8   2 | 9   7   6 | 4   1   5
    -----------|-----------|------------
     7   9   5 | 4   8   1 | 6   2   3
    ===========+===========+============
     5   7   9 | 8   6   4 | 1   3   2
    -----------|-----------|------------
     6   1   3 | 7   2   9 | 5   4   8
    -----------|-----------|------------
     4   2   8 | 5   1   3 | 9   7   6
    ===========+===========+============
     2   4   6 | 1   5   8 | 3   9   7
    -----------|-----------|------------
     8   5   1 | 3   9   7 | 2   6   4
    -----------|-----------|------------
     9   3   7 | 6   4   2 | 8   5   1


### Running The Program
There is an executable jar in this repository. Each time I update the source code, I will also update this jar. If you're running a Linux distro, make sure you `chmod +x` if you wish to open it from your file manager. 

Otherwise, you can start the program by running `java -jar "Sudoku-Solver.jar"` in the directory containing your file. You must have the `data` folder in the same directory as the jar.

### MIT License
> Copyright (c) 2018 Austin FitzGerald
> 
> Permission is hereby granted, free of charge, to any person obtaining
> a copy of this software and associated documentation files (the
> "Software"), to deal in the Software without restriction, including
> without limitation the rights to use, copy, modify, merge, publish,
> distribute, sublicense, and/or sell copies of the Software, and to
> permit persons to whom the Software is furnished to do so, subject to
> the following conditions:
> 
> The above copyright notice and this permission notice shall be
> included in all copies or substantial portions of the Software.
> 
> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
> EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
> MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
> IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
> CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
> TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
> SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.