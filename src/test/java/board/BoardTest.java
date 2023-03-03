package board;

import org.junit.jupiter.api.Test;
import util.PuzzleException;
import util.Utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class for testing invalid boards
 */
public class BoardTest {
    /**
     * Tests if state has number duplicate
     */
    @Test
    public void testBoardDupeNumbers() {
        int[][] invalid1 = {{0, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 1, 1}};//dupe
        Board board = new Board(invalid1);
        assertThrows(PuzzleException.class, () -> {
            Utils.checkInput(board);
        });
    }

    /**
     * Tests if state array is too small
     */
    @Test
    public void testBoardTooSmall() {
        int[][] invalid2 = {{0, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2}};//size
        Board board = new Board(invalid2);
        assertThrows(PuzzleException.class, () -> {
            Utils.checkInput(board);
        });
    }

    /**
     * Tests if state array is too big
     */
    @Test
    public void testBoardTooBig() {
        int[][] invalid3 = {{0, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1, 4}};//size
        Board board = new Board(invalid3);
        assertThrows(PuzzleException.class, () -> {
            Utils.checkInput(board);
        });
    }

    /**
     * Tests if state has number outside range 1-15
     */
    @Test
    public void testBoardNumbersOutOfRange1() {
        int[][] invalid4 = {{0, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 1, 16}};//number outside range
        Board board = new Board(invalid4);
        assertThrows(PuzzleException.class, () -> {
            Utils.checkInput(board);
        });
    }

    /**
     * Tests if state array has bigger size than intended
     */
    @Test
    public void testBoardNumbersOutOfRange2() {
        int[][] invalid4 = {{0, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 1, 2}, {1, 2, 3, 4}};//array outside range
        Board board = new Board(invalid4);
        assertThrows(PuzzleException.class, () -> {
            Utils.checkInput(board);
        });
    }
}
