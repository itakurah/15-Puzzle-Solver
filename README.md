# 15-Puzzle-Solver
This software project involves solving the 15-Puzzle sliding game using both the A* and IDA* algorithms. The Manhattan-Heuristic, Hamming-Distance, and Linear-Conflict Heuristics are used to determine the cost of each move and guide the search for the optimal solution. The A* algorithm guarantees finding the optimal solution while IDA* is the optimized version of the A* algorithm which uses less memory. The heuristics used in this project are well-known and widely used in the field of artificial intelligence, providing a high level of accuracy in finding the solution to the 15-Puzzle game.
## Usage
In the `Application.java` file, you can either auto-generate a random puzzle using the `Utils.getRandomPuzzle()` method or create your own by calling `Utils.convertStringTo2DIntArray(e.g. "5, 11, 0, 2, 6, 10, 1, 4 13, 12, 3, 7 14, 9, 15, 8")`. Then you need to select the solving algorithm `AStar` or `IDAStar` and set the parameters using e.g.: `AStar.solve(board, new ManhattanDistance() OR new HammingDistance() OR new LinearConflictWithMD(), TimeUnit.= MS or NS, DebugMode.=ON or OFF);
`
## About
This project, created by Niklas Hoefflin, is a submission for the Intelligent Systems module at the Hamburg University of Applied Sciences under the supervision of Prof. Dr. Peer Stelldinger. It is shared on GitHub for educational and reference purposes only and can be used for commercial or any other non-academic purposes without the author's permission.
## License
This project is licensed under the MIT License. Please see the [LICENSE.md](https://github.com/itakurah/HAW-IS-15-Puzzle-Solver/blob/main/LICENSE) file for details.

