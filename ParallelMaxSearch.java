public class ParallelMaxSearch extends SensorSearchEngine {
    public ParallelMaxSearch(double[] sensorData,
                             int startIdx,
                             int endIdx) {
        super(sensorData, startIdx, endIdx);
    }
    @Override
    public double processGrid() {
        double max = sensorData[startIdx];
        for (int i = startIdx; i < endIdx; i++) {
            if (sensorData[i] > max) {
                max = sensorData[i];
            }
        }
        return max;
    }
}