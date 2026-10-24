public class CacheLocalityBenchmark {// Traverse matrix row by row


    static final int SIZE = 2000;
    static double[][] matrix = new double[SIZE][SIZE];

    public static void initializeMatrix() {

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                matrix[i][j] = 1.0;
            }
        }
    }

    public static double traverseRowMajor() {

        double sum = 0;

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                sum += matrix[i][j];
            }
        }

        return sum;
    }

    public static double traverseColumnMajor() {

        double sum = 0;

        for (int j = 0; j < SIZE; j++) {

            for (int i = 0; i < SIZE; i++) {

                sum += matrix[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        initializeMatrix();

        long totalRowTime = 0;
        long totalColumnTime = 0;

        for (int k = 1; k <= 10; k++) {

            long startRow = System.nanoTime();

            traverseRowMajor();

            long endRow = System.nanoTime();

            totalRowTime += (endRow - startRow);

            long startColumn = System.nanoTime();

            traverseColumnMajor();

            long endColumn = System.nanoTime();

            totalColumnTime += (endColumn - startColumn);
        }

        double rowMs = totalRowTime / 1000000.0;
        double columnMs = totalColumnTime / 1000000.0;

        double speedup = columnMs / rowMs;

        System.out.println("Row Major Time: "
                + rowMs + " ms");

        System.out.println("Column Major Time: "
                + columnMs + " ms");

        System.out.println("Speedup Ratio: "
                + speedup);
    }
}
