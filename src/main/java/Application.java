import algorithm.AStar;
import algorithm.IDAStar;
import board.Board;
import heuristic.HammingDistance;
import heuristic.LinearConflictWithMD;
import heuristic.ManhattanDistance;
import util.DebugMode;
import util.TimeUnit;
import util.Utils;
import java.util.Arrays;

/**
 * Entry point for the 15-puzzle application
 */
public class Application {
    public static void main(String[] args) {
//        int[][] puzzle = Utils.convertStringTo2DIntArray("5, 11, 0, 2, 6, 10, 1, 4 13, 12, 3, 7 14, 9, 15, 8");//depth30
        int[][] puzzle = Utils.getRandomPuzzle();//creates random puzzle from depth 1-80
        Board board = new Board(puzzle);
        board.show();
        /**
         *         Available algorithms:
         *         AStar and IDAStar
         *
         *         Available heuristics:
         *         Manhattan, Hamming, Linear Conflict
         *
         *         Available time units:
         *         MS(milliseconds) and NS(nanoseconds)
         *
         *         Available debug options:
         *         OFF and ON
         */

        //-----------ASTAR-----------
//        AStar.solve(board, new ManhattanDistance(), TimeUnit.MS, DebugMode.ON);
//        AStar.solve(board, new HammingDistance(), TimeUnit.MS, DebugMode.ON);
//        AStar.solve(board, new LinearConflictWithMD(), TimeUnit.MS, DebugMode.ON);
        //---------------------------

        //-----------IDASTAR---------
//        IDAStar.solve(board, new ManhattanDistance(), TimeUnit.MS, DebugMode.ON);
//        IDAStar.solve(board, new HammingDistance(), TimeUnit.MS, DebugMode.ON);
        IDAStar.solve(board, new LinearConflictWithMD(), TimeUnit.MS, DebugMode.ON);
        //---------------------------
    }
}
