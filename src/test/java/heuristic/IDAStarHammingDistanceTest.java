package heuristic;

import algorithm.IDAStar;
import algorithm.Result;
import board.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DebugMode;
import util.ReadPuzzlesFromFile;
import util.TimeUnit;
import util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for testing the hamming distance heuristic with IDA*
 */
public class IDAStarHammingDistanceTest {
    /**
     * Tests if solved puzzles depth is equal to precalculated optimal values
     * WARNING: You may need to adjust the sublist size
     * depending on the power of your system
     */
    @Test
    void testHamming() {
        for (int i = 1; i < 28; i++) {
            List<int[][]> listPuzzle = ReadPuzzlesFromFile.read("src/main/resources/puzzles/puzzles" + i + ".txt");
            List<Board> boardList = listPuzzle.stream().map(Board::new).collect(Collectors.toCollection(ArrayList::new));
            for (Board b : boardList) {
                Result result = IDAStar.solve(b, new HammingDistance(), TimeUnit.NS, DebugMode.ON);
                Assertions.assertArrayEquals(new Board(Utils.getGoal()).getState(), result.getFinalBoard().getState());
                Assertions.assertEquals(i, result.getFinalBoard().getGScore());
            }
        }
    }
}
