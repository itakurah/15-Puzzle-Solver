package algorithm;

import board.Board;
import heuristic.HammingDistance;
import heuristic.ManhattanDistance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DebugMode;
import util.TimeUnit;
import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tests if IDAStar search works correctly
 */
public class algorithmIDAStar {
    List<int[][]> puzzles = Arrays.asList(Utils.convertStringTo2DIntArray("1 2 3 4 5 6 7 8 9 10 11 12 13 14 0 15"),
            Utils.convertStringTo2DIntArray("1 2 7 3 5 6 12 4 9 10 11 8 13 14 15 0"),
            Utils.convertStringTo2DIntArray("1 2 3 4 5 10 15 0 9 7 8 6 13 11 14 12"),
            Utils.convertStringTo2DIntArray("1 4 12 7 5 0 3 15 9 2 11 8 13 6 14 10"),
            Utils.convertStringTo2DIntArray("6 5 2 3 15 14 13 7 0 11 8 4 10 9 1 12"));
    List<Integer> depth = List.of(1, 10, 20, 30, 40);
    List<String> movesHamming = new ArrayList<>();
    List<String> movesManhattan = new ArrayList<>();
    List<String> movesLinearConflict = new ArrayList<>();

    @Test
    public void testIDAStarHamming() {
        for (int i = 0; i < puzzles.size() - 1; i++) {
            Result result = IDAStar.solve(new Board(puzzles.get(i)), new HammingDistance(), TimeUnit.NS, DebugMode.ON);
            Assertions.assertEquals(depth.get(i), result.getDepth());
            movesHamming.add(result.getMoves());
        }
    }

    @Test
    public void testIDAStarManhattan() {
        for (int i = 0; i < puzzles.size() - 1; i++) {
            Result result = AStar.solve(new Board(puzzles.get(i)), new ManhattanDistance(), TimeUnit.NS, DebugMode.ON);
            Assertions.assertEquals(depth.get(i), result.getDepth());
            movesManhattan.add(result.getMoves());
        }
    }

    @Test
    public void testIDAStarLinearConflict() {
        for (int i = 0; i < puzzles.size(); i++) {
            Result result = AStar.solve(new Board(puzzles.get(i)), new ManhattanDistance(), TimeUnit.NS, DebugMode.ON);
            Assertions.assertEquals(depth.get(i), result.getDepth());
            movesLinearConflict.add(result.getMoves());
        }
    }

    @Test
    public void testIsEqual() {
        Assertions.assertEquals(movesManhattan, movesLinearConflict);
        Assertions.assertEquals(movesHamming.subList(0, movesHamming.size()), movesLinearConflict);
    }
}
