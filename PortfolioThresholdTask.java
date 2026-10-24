import java.util.concurrent.RecursiveAction;// RecursiveAction for portfolio adjustment
public class PortfolioThresholdTask extends RecursiveAction {
    private double[] assets;
    private int start;
    private int end;
    private double riskCap;
    private static final int THRESHOLD = 1000;
    public PortfolioThresholdTask(double[] assets,
                                  int start,
                                  int end,
                                  double riskCap) {
        this.assets = assets;
        this.start = start;
        this.end = end;
        this.riskCap = riskCap;// Apply five percent penalty above risk cap
    }
    @Override
    protected void compute() {
        if ((end - start) <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                if (assets[i] > riskCap) {// Process large arrays recursively
                    assets[i] = assets[i] * 0.95;
                }
            }
            return;
        }
        int mid = (start + end) / 2;
        PortfolioThresholdTask left =
                new PortfolioThresholdTask(
                        assets, start, mid, riskCap);
        PortfolioThresholdTask right =
                new PortfolioThresholdTask(
                        assets, mid, end, riskCap);
        invokeAll(left, right);
    }
}
