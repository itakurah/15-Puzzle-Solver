package heuristic;

import board.Board;

/**
 *
 */
public abstract class Heuristic {
    public abstract int calculate(Board board);

    public abstract String getName();
}
