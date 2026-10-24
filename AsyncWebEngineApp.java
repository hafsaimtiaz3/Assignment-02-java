public class AsyncWebEngineApp {// Main application entry point
    public static void main(String[] args) {
        System.out.println(
            "Main Thread Name: "
            + Thread.currentThread().getName()
        );
        TelemetryThread telemetry = new TelemetryThread();
        telemetry.setName("Telemetry-Worker");
        LogProcessorTask task = new LogProcessorTask();
        Thread logThread = new Thread(task);// Assign descriptive thread names
        logThread.setName("Log-Worker");
        telemetry.start();
        logThread.start();// Launch concurrent execution
        System.out.println("Both worker threads started.");
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        System.out.println(
            "Telemetry Thread Alive: "//Added thread state logging
            + telemetry.isAlive()
        );
        System.out.println(
            "Log Thread Alive: "
            + logThread.isAlive()
        );
    }
}
