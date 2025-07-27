package models;

public class AlgorithmResult {

    private String algorithmName;
    private int pathLength;
    private long executionTimeNano;

    public AlgorithmResult(String algorithmName, int pathLength, long executionTimeNano) {
        this.algorithmName = algorithmName;
        this.pathLength = pathLength;
        this.executionTimeNano = executionTimeNano;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public int getPathLength() {
        return pathLength;
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }

    public long getExecutionTimeNano() {
        return executionTimeNano;
    }

    public void setExecutionTimeNano(long executionTimeNano) {
        this.executionTimeNano = executionTimeNano;
    }

    @Override
    public String toString() {
        return algorithmName + "," + pathLength + "," + executionTimeNano;
    }
}
