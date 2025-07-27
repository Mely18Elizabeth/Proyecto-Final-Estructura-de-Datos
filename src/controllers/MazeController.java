package controllers;

import dao.AlgorithmResultDAO;
import models.AlgorithmResult;
import models.Cell;
import models.CellState;
import models.SolveResults;
import solver.MazeSolver;

public class MazeController {

    private Cell[][] maze; // Matriz del laberinto
    private MazeSolver solver; // Estrategia de resolución
    private AlgorithmResultDAO resultDAO; // Persistencia de resultados
    private SolveResults solveResults; // Resultados en memoria

    public MazeController(Cell[][] maze, MazeSolver solver, AlgorithmResultDAO resultDAO, SolveResults solveResults) {
        this.maze = maze;
        this.solver = solver;
        this.resultDAO = resultDAO;
        this.solveResults = solveResults;
    }

    public void setMaze(Cell[][] maze) {
        this.maze = maze;
    }

    public void setSolver(MazeSolver solver) {
        this.solver = solver;
    }

    /**
     * Ejecuta el algoritmo de resolución sobre el laberinto.
     * Guarda el resultado en archivo y memoria, y retorna si se encontró camino.
     */
    public boolean resolverLaberinto() {
        Cell inicio = buscarCelda(CellState.START);
        Cell fin = buscarCelda(CellState.END);

        if (inicio == null || fin == null) {
            System.out.println("Debe haber un punto de inicio y fin.");
            return false;
        }

        long tiempoInicio = System.nanoTime();
        boolean exito = solver.solve(maze, inicio.getRow(), inicio.getCol(), fin.getRow(), fin.getCol());
        long tiempoFin = System.nanoTime();

        if (exito) {
            int longitudCamino = contarCeldas(CellState.PATH);

            AlgorithmResult resultado = new AlgorithmResult(
                solver.getNombre(),
                longitudCamino,
                tiempoFin - tiempoInicio
            );

            solveResults.addOrUpdateResult(resultado);
            resultDAO.guardar(resultado);
        }

        return exito;
    }

    private Cell buscarCelda(CellState tipo) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].getState() == tipo) {
                    return maze[i][j];
                }
            }
        }
        return null;
    }

    private int contarCeldas(CellState tipo) {
        int contador = 0;
        for (Cell[] fila : maze) {
            for (Cell celda : fila) {
                if (celda.getState() == tipo) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public SolveResults getSolveResults() {
        return solveResults;
    }
}
