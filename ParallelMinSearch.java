public class ParallelMinSearch extends SensorSearchEngine {// Finds minimum sensor value in assigned partition
    public ParallelMinSearch(double[] sensorData,
                             int startIdx,
                             int endIdx) {
        super(sensorData, startIdx, endIdx);
    }
    @Override
    public double processGrid() {
        double min = sensorData[startIdx];
        for (int i = startIdx; i < endIdx; i++) {
            if (sensorData[i] < min) {
                min = sensorData[i];
            }
        }
        return min;
    }
}
