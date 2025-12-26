import java.util.Random;
import java.util.Scanner;

public class java5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмірність квадратної матриці: ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Початкова матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(100);
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }

        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        System.out.println("\nТранспонована матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", transposed[i][j]);
            }
            System.out.println();
        }
    }
}