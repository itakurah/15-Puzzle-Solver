package heuristic;

import board.Board;

/**
 * Class for the hamming distance heuristic
 */
public class HammingDistance extends Heuristic {
    /**
     * Calculates the hamming distance of the given board
     * Hamming distance is the number of tiles not
     * in their goal position, blank tile is ignored
     *
     * @param board Board Object
     * @return hamming distance count
     */
    @Override
    public int calculate(Board board) {
        int hdCount = 0;
        int goalPosition = 0;
        for (int i = 0; i < Board.BOARD_LENGTH; i++) {
            for (int j = 0; j < Board.BOARD_LENGTH; j++) {
                goalPosition++;
                if (board.getState()[i][j] != goalPosition && !(board.getState()[i][j] == 0)) {
                    hdCount++;
                }
            }
        }
        return hdCount;
    }

    @Override
    public String getName() {
        return "Hamming Distance";
    }
}
