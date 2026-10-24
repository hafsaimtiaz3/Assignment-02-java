public class LogProcessorTask implements Runnable {// Runnable task for processing system logs
    @Override
    // Executes log processing loop
    public void run() {
        // Repeat logging five times
        for (int i = 1; i <= 5; i++) {

            System.out.println(
                Thread.currentThread().getName()
                System.out.println("Thread: " + Thread.currentThread().getName());
                + " -> Processing Log " + i
            );
            try {
                // Pause execution for one second
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        }
    }
}
