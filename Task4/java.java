public class java {
    public static void main(String[] args) {
        int rows = 5;
        int[][] pyramid = new int[rows][];

        for (int i = 0; i < rows; i++) {
            pyramid[i] = new int[i + 1];
            for (int j = 0; j < pyramid[i].length; j++) {
                pyramid[i][j] = j + 1;
            }
        }

        System.out.println("Звичайний порядок (Піраміда):");
        for (int i = 0; i < rows; i++) {
            for (int num : pyramid[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("\nЗворотний порядок (Перевернута піраміда):");
        for (int i = rows - 1; i >= 0; i--) {
            for (int num : pyramid[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}