# Proyecto Final – Estructura de Datos

**Carrera:** Computación  
**Asignatura:** Estructura de Datos – Segundo Interciclo  
**Docente:** Ing. Pablo Torres  
**Estudiantes:**  
- Janelly Dayanna Chacha Vélez  
- Melany Elizabeth Pintado  
**Correos institucionales:**  
- jchachav@est.ups.edu.ec
- 

---

## 🧩 Descripción del Problema

El proyecto consiste en desarrollar una aplicación que encuentre la **ruta óptima** desde un punto de inicio (A) hasta un punto destino (B) dentro de un **laberinto**, el cual es representado como una matriz de celdas transitables y no transitables. El objetivo es aplicar algoritmos de búsqueda y técnicas de **programación dinámica** para optimizar dicha búsqueda.

---

## 💡 Propuesta de Solución

### 📚 Marco Teórico

Se implementaron los siguientes algoritmos:

- **BFS (Breadth-First Search)**: Explora por niveles, ideal para encontrar la ruta más corta.
- **DFS (Depth-First Search)**: Explora por profundidad, útil para explorar completamente un camino antes de retroceder.
- **Backtracking**: Permite explorar caminos posibles y retroceder si se encuentra un obstáculo.
- **Recursión en 2 y 4 direcciones**: Implementa la búsqueda considerando movimientos limitados o completos en la matriz.

### 🛠 Tecnologías Utilizadas

- Java (JDK 11+)
- Swing (para interfaz gráfica)
- Archivos `.csv` para almacenamiento de tiempos de ejecución
- Git y GitHub para control de versiones

### 🧩 Diagrama UML

![Diagrama UML](./uml_diagrama.png)  
*El diagrama muestra las clases del modelo, controlador y vista (MVC).*

---

## 🖼 Capturas de la Interfaz

### Interfaz principal:
![Interfaz Laberinto](./interfaz_1.png)

### Ejemplo de solución:
![Ejemplo de Solución](./interfaz_2.png)
