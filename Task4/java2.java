import java.util.Random;

public class java2 {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 4;
        double[][] matrix = new double[rows][cols];
        Random random = new Random();

        System.out.println("Початкова матриця:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
                System.out.printf("%6.2f ", matrix[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
             
                if (i % 2 != 0 || j % 2 != 0) {
                    matrix[i][j] = Math.sqrt(matrix[i][j]);
                }
            }
        }

        System.out.println("\nЗмінена матриця (корінь з елементів на непарних позиціях):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%6.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}