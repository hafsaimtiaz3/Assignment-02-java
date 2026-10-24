public class AsyncWebEngineApp {// Main application entry point
    public static void main(String[] args) {
        System.out.println(
            "Main Thread Name: "
            + Thread.currentThread().getName()
        );
        TelemetryThread telemetry = new TelemetryThread();
        telemetry.setName("Telemetry-Worker");
        LogProcessorTask task = new LogProcessorTask();
        Thread logThread = new Thread(task);
        logThread.setName("Log-Worker");
        telemetry.start();
        logThread.start();
        System.out.println("Both worker threads started.");
        System.out.println(
            "Telemetry Thread Alive: "
            + telemetry.isAlive()
        );
        System.out.println(
            "Log Thread Alive: "
            + logThread.isAlive()
        );
    }
}
