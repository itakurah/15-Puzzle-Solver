package heuristic;

import board.Board;

/**
 * Superclass for heuristics
 */
public abstract class Heuristic {
    public abstract int calculate(Board board);

    public abstract String getName();
}
