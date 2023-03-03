package algorithm;

import board.Board;
import heuristic.Heuristic;

/**
 * Class for the result objects to better handle tests and comparison between algorithms and heuristics
 */
public class Result {
    private final Board finalBoard;
    private final String algorithmType;
    private final Heuristic heuristic;
    private final int totalExpandedBoards;
    private final int totalOpenListSize;
    private final int totalClosedListSize;
    private final long totalMemoryUsed;
    private final long totalRunTime;
    private final String movesToSolve;

    public Result(Board finalBoard, String algorithmType, Heuristic heuristic, int totalExpandedBoards,
                  int totalOpenListSize, int totalClosedListSize, long totalMemoryUsed, long totalRunTime, String movesToSolve) {
        this.finalBoard = finalBoard;
        this.algorithmType = algorithmType;
        this.heuristic = heuristic;
        this.totalOpenListSize = totalOpenListSize;
        this.totalClosedListSize = totalClosedListSize;
        this.totalExpandedBoards = totalExpandedBoards;
        this.totalMemoryUsed = totalMemoryUsed;
        this.totalRunTime = totalRunTime;
        this.movesToSolve = movesToSolve;
    }

    public Board getFinalBoard() {
        return finalBoard;
    }

    public String getAlgorithm() {
        return algorithmType;
    }

    public String getName() {
        return heuristic.getName();
    }

    public int getExpandedBoards() {
        return totalExpandedBoards;
    }

    public int getDepth() {
        return finalBoard.getGScore();
    }

    public long getMemoryUsed() {
        return totalMemoryUsed;
    }

    public long getRunTime() {
        return totalRunTime;
    }

    public String getMoves() {
        return movesToSolve;
    }

    public int getOpenListSize() {
        return totalOpenListSize;
    }

    public int getClosedListSize() {
        return totalClosedListSize;
    }
}
