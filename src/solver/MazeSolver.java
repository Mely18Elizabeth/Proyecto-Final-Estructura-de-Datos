package solver;

import models.Cell;

public interface MazeSolver {
    /**
     * Resuelve el laberinto desde (startRow, startCol) hasta (endRow, endCol).
     * @return true si se encontró un camino.
     */
    boolean solve(Cell[][] maze, int startRow, int startCol, int endRow, int endCol);

    /**
     * Retorna el nombre del algoritmo (usado en resultados y UI).
     */
    String getNombre();
}
