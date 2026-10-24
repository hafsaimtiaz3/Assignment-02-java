import java.util.*;
import java.util.concurrent.*;

public class InventoryCatalogManager {

    private static final int THREADS = 10;
    private static final int OPERATIONS = 50000;

    public static void benchmarkSynchronizedMap() {

        Map<String, Integer> catalog =
                Collections.synchronizedMap(new HashMap<>());

        long startTime = System.currentTimeMillis();

        ExecutorService executor =
                Executors.newFixedThreadPool(THREADS);

        for (int i = 0; i < THREADS; i++) {

            executor.execute(() -> {

                for (int j = 0; j < OPERATIONS; j++) {

                    String productId =
                            "P" + (j % 1000);

                    catalog.put(productId, j);

                    catalog.get(productId);
                }
            });
        }

        executor.shutdown();

        try {
            executor.awaitTermination(
                    1,
                    TimeUnit.MINUTES
            );
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;

        double throughput =
                (THREADS * OPERATIONS)
                        / (totalTime / 1000.0);

        System.out.println("\n===== SynchronizedMap =====");
        System.out.println("Execution Time: "
                + totalTime + " ms");

        System.out.println("Throughput: "
                + (long) throughput
                + " operations/second");
    }

    public static void benchmarkConcurrentMap() {

        ConcurrentHashMap<String, Integer> catalog =
                new ConcurrentHashMap<>();

        long startTime = System.currentTimeMillis();

        ExecutorService executor =
                Executors.newFixedThreadPool(THREADS);

        for (int i = 0; i < THREADS; i++) {

            executor.execute(() -> {

                for (int j = 0; j < OPERATIONS; j++) {

                    String productId =
                            "P" + (j % 1000);

                    catalog.put(productId, j);

                    catalog.get(productId);
                }
            });
        }

        executor.shutdown();

        try {
            executor.awaitTermination(
                    1,
                    TimeUnit.MINUTES
            );
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;

        double throughput =
                (THREADS * OPERATIONS)
                        / (totalTime / 1000.0);

        System.out.println("\n===== ConcurrentHashMap =====");
        System.out.println("Execution Time: "
                + totalTime + " ms");

        System.out.println("Throughput: "
                + (long) throughput
                + " operations/second");
    }

    public static void main(String[] args) {

        benchmarkSynchronizedMap();

        benchmarkConcurrentMap();
    }
}