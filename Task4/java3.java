import java.util.Scanner;

public class java3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5;
        int[][] matrix = new int[n][n];

        System.out.println("Введіть елементи матриці 5x5 (25 чисел):");
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("M[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        long determinant = calculateDeterminant(matrix);
        System.out.println("Визначник матриці: " + determinant);
    }

  
    public static long calculateDeterminant(int[][] mat) {
        int n = mat.length;
        if (n == 1) return mat[0][0];
        if (n == 2) return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];

        long det = 0;
        for (int col = 0; col < n; col++) {
            det += Math.pow(-1, col) * mat[0][col] * calculateDeterminant(getSubMatrix(mat, 0, col));
        }
        return det;
    }

 
    public static int[][] getSubMatrix(int[][] mat, int rowToRemove, int colToRemove) {
        int n = mat.length;
        int[][] newMat = new int[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) continue;
                newMat[r][c] = mat[i][j];
                c++;
            }
            r++;
        }
        return newMat;
    }
}