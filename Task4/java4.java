import java.util.Random;
import java.util.Scanner;

public class java4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір матриці (N): ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Згенерована матриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(10);
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.print("Введіть індекс рядка для мінору (0 ... " + (n-1) + "): ");
        int row = scanner.nextInt();
        System.out.print("Введіть індекс стовпця для мінору (0 ... " + (n-1) + "): ");
        int col = scanner.nextInt();

        if (row < 0 || row >= n || col < 0 || col >= n) {
            System.out.println("Невірні індекси!");
            return;
        }

        int[][] subMatrix = getSubMatrix(matrix, row, col);
        long minor = calculateDeterminant(subMatrix);

        System.out.println("Мінор елемента [" + row + "][" + col + "] = " + minor);
    }

    public static long calculateDeterminant(int[][] mat) {
        int size = mat.length;
        if (size == 1) return mat[0][0];
        if (size == 2) return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];

        long det = 0;
        for (int c = 0; c < size; c++) {
            det += Math.pow(-1, c) * mat[0][c] * calculateDeterminant(getSubMatrix(mat, 0, c));
        }
        return det;
    }

    public static int[][] getSubMatrix(int[][] mat, int rowToRemove, int colToRemove) {
        int size = mat.length;
        int[][] newMat = new int[size - 1][size - 1];
        int r = 0;
        for (int i = 0; i < size; i++) {
            if (i == rowToRemove) continue;
            int c = 0;
            for (int j = 0; j < size; j++) {
                if (j == colToRemove) continue;
                newMat[r][c] = mat[i][j];
                c++;
            }
            r++;
        }
        return newMat;
    }
}