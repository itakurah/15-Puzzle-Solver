package algorithm;

import board.Board;
import com.google.common.base.Stopwatch;
import heuristic.Heuristic;
import util.DebugMode;
import util.Utils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Class for the AStar algorithm
 */
public abstract class AStar {
    private static final long KILOBYTES = 1024L;
    private static final PriorityQueue<Board> openList = new PriorityQueue<>(Comparator.comparing(Board::getFScore));
    private static final Set<Board> closedList = new HashSet<>();

    /**
     * Solves a valid given 15-puzzle using AStar algorithm
     *
     * @param initialBoard Start board to solve
     * @param timeUnit     Unit for runtime (MS = milliseconds, NS = nanoseconds)
     * @param debugMode    Print results to console (ON = print information, OFF = print no information)
     * @param heuristic    Type of heuristic
     * @return Result object
     */
    public static Result solve(Board initialBoard, Heuristic heuristic, util.TimeUnit timeUnit, DebugMode debugMode) {
        Utils.checkInput(initialBoard);
        Board BoardCopy = new Board(initialBoard.getState());//copy board
        BoardCopy.setHeuristic(heuristic);
        BoardCopy.setHScore(heuristic.calculate(BoardCopy));
        TimeUnit unit = switch (timeUnit) {
            case MS -> TimeUnit.MILLISECONDS;
            case NS -> TimeUnit.NANOSECONDS;
        };
        Stopwatch stopwatch = Stopwatch.createUnstarted();//create timer
        stopwatch.start();//start timer
        //clear up
        openList.clear();
        closedList.clear();
        int numOfExpandedBoards = 0;
        openList.add(BoardCopy);
        while (!openList.isEmpty()) {
            Board currentBoard = openList.poll();
            if (currentBoard.isSolution()) {
                stopwatch.stop();
                Runtime runtime = Runtime.getRuntime();
                runtime.gc();
                long memory = runtime.totalMemory() - runtime.freeMemory();
                memory = memory / KILOBYTES;
                if (debugMode == DebugMode.ON) {
                    Utils.printResults("AStar", heuristic, numOfExpandedBoards,
                            openList, closedList, currentBoard, null, memory, stopwatch.elapsed(unit));//print results
                }
                return new Result(currentBoard, "AStar", heuristic, numOfExpandedBoards, openList.size(),
                        closedList.size(), memory, stopwatch.elapsed(unit), Utils.getMoves(currentBoard));
            }
            closedList.add(currentBoard);
            currentBoard.setSuccessors(currentBoard.generateSuccessors());
//            numOfExpandedBoards += currentBoard.getSuccessors().size();
            Iterator<Board> iteratorCurrentBoard = currentBoard.getSuccessors().iterator();
            while (iteratorCurrentBoard.hasNext()) {//using an iterator over foreach-loop there is a save of approx. 20% memory usage
                Board successor = iteratorCurrentBoard.next();
                if (closedList.contains(successor)) {
                    iteratorCurrentBoard.remove();
                    continue;
                }
                numOfExpandedBoards++;
                openList.add(successor);
            }
        }
        System.out.println("No solution found");
        return new Result(BoardCopy, "AStar", heuristic, numOfExpandedBoards,
                0, 0, 0, stopwatch.elapsed(TimeUnit.NANOSECONDS), "no moves");
    }

}

