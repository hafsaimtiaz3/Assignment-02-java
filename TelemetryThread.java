public class TelemetryThread extends Thread {// Dedicated thread for telemetry monitoring
    @Override
    public void run() {// Monitor CPU and memory statistics
        for (int i = 1; i <= 5; i++) {// Perform five telemetry checks

            System.out.println(
                Thread.currentThread().getName()
                + " -> CPU and Memory Health Update "
                + i
            );
            try {
                Thread.sleep(800);// Wait before next telemetry update
            }
            catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        }
    }
}
