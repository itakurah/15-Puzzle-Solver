package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for loading puzzles from disk
 */
public abstract class ReadPuzzlesFromFile {
    public static ArrayList<int[][]> read(String fileName) {
        ArrayList<int[][]> results = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner boardFile = new Scanner(bufferedReader);
            while (boardFile.hasNextLine()) {
                int[][] row = new int[4][4];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        row[i][j] = boardFile.nextInt();
                    }
                }
                results.add(row);
                if (boardFile.hasNextLine()) {
                    boardFile.nextLine();
                }
            }
            boardFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file: " + fileName);
        }
        return results;
    }
}
