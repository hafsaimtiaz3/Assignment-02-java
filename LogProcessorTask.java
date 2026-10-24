public class LogProcessorTask implements Runnable {// Runnable task for processing system logs
    @Override
    // Executes log processing loop
    public void run() {
        for (int i = 1; i <= 5; i++) {

            System.out.println(
                Thread.currentThread().getName()
                + " -> Processing Log " + i
            );
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        }
    }
}
