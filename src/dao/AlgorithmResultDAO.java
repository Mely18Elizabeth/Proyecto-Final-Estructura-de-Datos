package dao;

import models.AlgorithmResult;
import java.util.List;

public interface AlgorithmResultDAO {

    void guardar(AlgorithmResult resultado);

    List<AlgorithmResult> cargarTodos();

    void limpiar();
}
