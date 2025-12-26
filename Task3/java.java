import java.util.Random;
import java.util.Scanner;

public class java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Генерація масиву
        System.out.print("Масив: ");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Підрахунок
        int evenCount = 0;
        int oddCount = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Кількість парних: " + evenCount);
        System.out.println("Кількість непарних: " + oddCount);
    }
}