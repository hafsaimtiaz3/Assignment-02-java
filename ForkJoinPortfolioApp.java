import java.util.Random;// Main application entry point
import java.util.concurrent.ForkJoinPool;
public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        double[] assets = new double[10000];// Generate ten thousand asset values
        Random random = new Random();
        for (int i = 0; i < assets.length; i++) {// Initialize Fork Join pool
            assets[i] = 100 + random.nextInt(5000);
        }
        ForkJoinPool pool = new ForkJoinPool();
        long startTime = System.currentTimeMillis();
        ParallelRiskCalculator riskTask =
                new ParallelRiskCalculator(
                        assets,
                        0,
                        assets.length
                );
        double totalRisk = pool.invoke(riskTask);
        PortfolioThresholdTask thresholdTask =
                new PortfolioThresholdTask(
                        assets,
                        0,
                        assets.length,
                        3000
                );
        pool.invoke(thresholdTask);
        long endTime = System.currentTimeMillis();
        System.out.println("Total Risk Score: "
                + totalRisk);
        System.out.println("Processing Time: "
                + (endTime - startTime)
                + " ms");
        System.out.println("Portfolio Stress Test Completed");
    }
}
