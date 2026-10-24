import java.util.Random;

public class SensorGridMonitorApp {

    public static void main(String[] args)
            throws InterruptedException {

        double[] sensorData = new double[50000];

        Random random = new Random();

        for (int i = 0; i < sensorData.length; i++) {
            sensorData[i] = random.nextDouble() * 1000;
        }

        long startTime = System.currentTimeMillis();

        final double[] globalMin = new double[1];
        final double[] globalMax = new double[1];

        Thread minThread = new Thread(() -> {

            double minValue = Double.MAX_VALUE;

            int partSize = sensorData.length / 4;

            for (int i = 0; i < 4; i++) {

                int start = i * partSize;
                int end = (i == 3)
                        ? sensorData.length
                        : start + partSize;

                ParallelMinSearch search =
                        new ParallelMinSearch(
                                sensorData,
                                start,
                                end
                        );

                double localMin = search.processGrid();

                if (localMin < minValue) {
                    minValue = localMin;
                }
            }

            globalMin[0] = minValue;
        });

        Thread maxThread = new Thread(() -> {

            double maxValue = Double.MIN_VALUE;

            int partSize = sensorData.length / 4;

            for (int i = 0; i < 4; i++) {

                int start = i * partSize;
                int end = (i == 3)
                        ? sensorData.length
                        : start + partSize;

                ParallelMaxSearch search =
                        new ParallelMaxSearch(
                                sensorData,
                                start,
                                end
                        );

                double localMax = search.processGrid();

                if (localMax > maxValue) {
                    maxValue = localMax;
                }
            }

            globalMax[0] = maxValue;
        });

        minThread.start();
        maxThread.start();

        minThread.join();
        maxThread.join();

        long endTime = System.currentTimeMillis();

        System.out.println("Minimum Temperature: "
                + globalMin[0]);

        System.out.println("Maximum Vibration: "
                + globalMax[0]);

        System.out.println("Execution Time: "
                + (endTime - startTime)
                + " ms");
    }
}