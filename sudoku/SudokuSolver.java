package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuSolver {
    // returns false is k in col
    public static boolean colCheck(int k, int[] col) {
        for (int i = 0; i < col.length; i++) {
            if (col[i] == k) {
                return false;
            }
        }
        return true;
    }

    // returns false if k in row
    public static boolean rowCheck(int k, int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == k) {
                return false;
            }
        }
        return true;
    }

    public static boolean gridCheck(int k, int[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    // attempt to place k in the x y coordiante of puzzle, return true if
    // permissible
    public static boolean attemptK(int k, int[][] puzzle, int i, int j) {
        if (rowCheck(k, puzzle[i])) {
            if (colCheck(k, getColumn(puzzle, j))) {
                int[][] grid = new int[3][3];
                //There are 9 possible grids i j could be in
                //int gridIndex = ((i  / 3)* 3 + (j / 3));
                
                for(int a = 0; a<3; a++){
                    for(int b = 0; b<3; b++){
                        grid[a][b] = puzzle[a+((i  / 3)* 3)][b+(j / 3)];
                    }
                }
                if (gridCheck(k, grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] getColumn(int[][] array, int index) {
        int[] column = new int[array[0].length]; // Here I assume a rectangular 2D array!
        for (int i = 0; i < column.length; i++) {
            column[i] = array[i][index];
        }
        return column;
    }

    public static void main(String[] args) throws IOException {
        // A sudoku grid is read in as a text file
        BufferedReader br = new BufferedReader(
                new FileReader("C:/Users/andre/Desktop/git/Java_Projects/sudoku/input.txt"));
        String everything = "";
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }
        System.out.println("***************************************");
        everything = everything.replaceAll(",", "");
        System.out.println(everything);
        everything = everything.replaceAll("\\s+", "");
        char[][] charPuzzle = new char[9][9];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                charPuzzle[i][j] = everything.charAt(index);
                index = index + 1;

            }
        }
        int[][] intPuzzle = new int[9][9];
        System.out.println("");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (charPuzzle[i][j] == 'x') {
                    intPuzzle[i][j] = 0;
                } else {
                    intPuzzle[i][j] = Character.getNumericValue(charPuzzle[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(intPuzzle[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");

        int gridIndex = ((8  / 3)* 3 + (8 / 3));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (intPuzzle[i][j] == 0) {
                    for (int k = 0; k < 9; k++) {
                        boolean placeK =  attemptK(k, intPuzzle, i, j);
                        if (placeK) {
                            intPuzzle[i][j] = k;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(intPuzzle[i][j]+" ");
            }
            System.out.println("");
        }

    }
}