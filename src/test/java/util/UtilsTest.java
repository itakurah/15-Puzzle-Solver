package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.Utils.convertStringTo2DIntArray;

/**
 * Class for testing if given state is unsolvable
 */
public class UtilsTest {
    final int NUMBER_OF_PUZZLES = 55;

    /**
     * Tests if puzzle is unsolvable
     */
    @Test
    void testIsNotSolvable() {
        int[][] unsolvable1 = {{13, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {1, 14, 15, 0}};//23
        int[][] unsolvable2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 15, 14, 0}};//1
        int[][] unsolvable3 = {{15, 5, 13, 9}, {2, 12, 0, 4}, {14, 7, 3, 6}, {10, 1, 8, 11}};//63
        ArrayList<int[][]> unsolvable = new ArrayList<>(List.of(unsolvable1, unsolvable2, unsolvable3));
        for (int[][] state : unsolvable
        ) {
            Assertions.assertFalse(Utils.isSolvable(state));
        }
    }

    /**
     * Tests if puzzle is solvable
     */
    @Test
    void testIsSolvable() {
        int[][] solvable1 = {{1, 2, 3, 4}, {6, 7, 8, 15}, {5, 10, 12, 11}, {9, 13, 0, 14}};//17
        int[][] solvable2 = {{13, 0, 2, 6}, {5, 1, 8, 3}, {9, 11, 7, 4}, {14, 15, 10, 12}};//33
        int[][] solvable3 = {{0, 9, 1, 2}, {5, 6, 8, 4}, {14, 7, 13, 15}, {10, 3, 12, 11}};//33
        ArrayList<int[][]> solvable = new ArrayList<>(List.of(solvable1, solvable2, solvable3));
        for (int[][] state : solvable
        ) {
            Assertions.assertTrue(Utils.isSolvable(state));
        }
    }

    /**
     * Tests if pre calculated puzzles are solvable
     */
    @Test
    void testIsSolvableStoredPuzzles() {
        for (int i = 1; i < NUMBER_OF_PUZZLES + 1; i++) {
            List<int[][]> listPuzzle = ReadPuzzlesFromFile.read("src/main/resources/puzzles/puzzles" + i + ".txt");
            for (int[][] solvableStates : listPuzzle
            ) {
                Assertions.assertTrue(Utils.isSolvable(solvableStates));
            }
        }
    }

    @Test
    public void testConvertStringTo2DIntArray() {
        //valid puzzle
        String input1 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0";
        String input2 = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0";
        String input3 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0";
        int[][] expected1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        int[][] actual1 = convertStringTo2DIntArray(input1);
        int[][] actual2 = convertStringTo2DIntArray(input2);
        int[][] actual3 = convertStringTo2DIntArray(input3);
        assertArrayEquals(expected1, actual1);
        assertArrayEquals(expected1, actual2);
        assertArrayEquals(expected1, actual3);

        //Puzzle has duplicate
        String input4 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,1";
        assertThrows(PuzzleException.class, () -> convertStringTo2DIntArray(input4));

        //Puzzle has digits not in range 0-15
        String input5 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16";
        assertThrows(PuzzleException.class, () -> convertStringTo2DIntArray(input5));
    }
}
