package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class SudokuSolver {
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
        everything = everything.replaceAll("\\s+", "");
        System.out.println(everything);
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
        }
    }
}