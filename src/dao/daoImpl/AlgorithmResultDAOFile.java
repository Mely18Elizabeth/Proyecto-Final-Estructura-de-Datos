package dao.daoImpl;

import dao.AlgorithmResultDAO;
import models.AlgorithmResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmResultDAOFile implements AlgorithmResultDAO {

    private final String archivo = "results.csv";

    @Override
    public void guardar(AlgorithmResult nuevo) {
        List<AlgorithmResult> existentes = cargarTodos();
        boolean actualizado = false;

        for (int i = 0; i < existentes.size(); i++) {
            AlgorithmResult r = existentes.get(i);
            if (r.getAlgorithmName().equals(nuevo.getAlgorithmName())) {
                existentes.set(i, nuevo);
                actualizado = true;
                break;
            }
        }

        if (!actualizado) {
            existentes.add(nuevo);
        }

        // Reescribir todo el archivo
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (AlgorithmResult r : existentes) {
                writer.println(r.toString()); // Usa el método toString() personalizado
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AlgorithmResult> cargarTodos() {
        List<AlgorithmResult> resultados = new ArrayList<>();

        File file = new File(archivo);
        if (!file.exists()) {
            return resultados;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    int longitud = Integer.parseInt(partes[1]);
                    long tiempo = Long.parseLong(partes[2]);
                    resultados.add(new AlgorithmResult(nombre, longitud, tiempo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultados;
    }

    @Override
    public void limpiar() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            // Sobrescribe el archivo con nada
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
