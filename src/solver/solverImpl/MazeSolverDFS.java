package solver.solverImpl;

import models.Cell;
import models.CellState;
import solver.MazeSolver;

import java.util.*;

public class MazeSolverDFS implements MazeSolver {

    @Override
    public boolean solve(Cell[][] maze, int startRow, int startCol, int endRow, int endCol) {
        int rows = maze.length;
        int cols = maze[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Map<Cell, Cell> parentMap = new HashMap<>();
        Stack<Cell> stack = new Stack<>();

        Cell start = maze[startRow][startCol];
        Cell end = maze[endRow][endCol];

        stack.push(start);
        visited[startRow][startCol] = true;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            if (current == end) {
                reconstruirCamino(parentMap, end);
                return true;
            }

            for (int[] dir : dirs) {
                int r = current.getRow() + dir[0];
                int c = current.getCol() + dir[1];

                if (r >= 0 && r < rows && c >= 0 && c < cols
                        && !visited[r][c] && maze[r][c].getState() != CellState.WALL) {
                    visited[r][c] = true;
                    stack.push(maze[r][c]);
                    parentMap.put(maze[r][c], current);
                    if (maze[r][c].getState() == CellState.EMPTY)
                        maze[r][c].setState(CellState.VISITED);
                }
            }
        }

        return false;
    }

    private void reconstruirCamino(Map<Cell, Cell> parentMap, Cell end) {
        Cell actual = parentMap.get(end);
        while (actual != null && actual.getState() != CellState.START) {
            actual.setState(CellState.PATH);
            actual = parentMap.get(actual);
        }
    }

    @Override
    public String getNombre() {
        return "DFS";
    }
}
