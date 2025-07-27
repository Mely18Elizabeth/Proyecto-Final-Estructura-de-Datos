package models;

import java.util.ArrayList;
import java.util.List;

public class SolveResults {

    private List<AlgorithmResult> results;

    public SolveResults() {
        results = new ArrayList<>();
    }

    public void addOrUpdateResult(AlgorithmResult newResult) {
        for (int i = 0; i < results.size(); i++) {
            AlgorithmResult r = results.get(i);
            if (r.getAlgorithmName().equals(newResult.getAlgorithmName())) {
                results.set(i, newResult); // Actualiza si ya existe
                return;
            }
        }
        results.add(newResult); // Si no existe, lo agrega
    }

    public List<AlgorithmResult> getResults() {
        return results;
    }

    public void clearResults() {
        results.clear();
    }
}
