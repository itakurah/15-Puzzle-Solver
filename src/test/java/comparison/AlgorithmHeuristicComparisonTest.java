package comparison;

import algorithm.AStar;
import algorithm.IDAStar;
import algorithm.Result;
import board.Board;
import heuristic.HammingDistance;
import heuristic.LinearConflictWithMD;
import heuristic.ManhattanDistance;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.DebugMode;
import util.ReadPuzzlesFromFile;
import util.TimeUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for comparing different heuristics used in solver
 * deactivated for normal test phase
 */
public class AlgorithmHeuristicComparisonTest {

    @Disabled
    public void testHeuristicComparison() {
        int count = 100;
        for (int i = 0; i < 42; i++) {
            int fileNum = i;//used to initialize runtime before measurement
            if (fileNum == 0) {
                fileNum = 1;
            }
            List<int[][]> listPuzzle = ReadPuzzlesFromFile.read("src/main/resources/puzzles/puzzles" + fileNum + ".txt");
            List<Board> boardList = listPuzzle.stream().map(Board::new).collect(Collectors.toCollection(ArrayList::new));
            float expandedBoards = 0;
            float time = 0;
            for (int j = 0; j < count; j++) {//iteration size
                for (Board board : boardList) {
                    Result result = AStar.solve(board, new ManhattanDistance(), TimeUnit.NS, DebugMode.OFF);//change algorithm and heuristic
                    expandedBoards += result.getExpandedBoards();
                    time += result.getRunTime();
                }
            }
            float finalTime = time / (boardList.size() * count);
            System.out.println(Float.toString(finalTime).replace(".",","));//display single avg time
            float finalBoards = expandedBoards / (boardList.size() * count);
//            System.out.println(Float.toString(finalBoards).replace(".",","));//display single avg boards
        }
    }
}

