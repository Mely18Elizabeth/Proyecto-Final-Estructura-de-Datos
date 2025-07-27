package models;

/**
 * Enum para representar el estado de una celda dentro del laberinto.
 */
public enum CellState {
    EMPTY,      // Celda libre
    WALL,       // Celda bloqueada (muro)
    START,      // Punto de inicio
    END,        // Punto de destino
    VISITED,    // Celda visitada durante el recorrido
    PATH        // Celda que forma parte del camino final
}
