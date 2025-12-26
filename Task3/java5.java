import java.util.Random;
import java.util.Scanner;

public class java5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.print("Масив: ");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Що перевірити?");
        System.out.println("1 - Чи масив зростає");
        System.out.println("2 - Чи масив спадає");
        int choice = scanner.nextInt();

        boolean isSorted = true;

        if (choice == 1) { 
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) { 
                    isSorted = false;
                    break;
                }
            }
            System.out.println("Масив зростає: " + isSorted);
        } else if (choice == 2) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    isSorted = false;
                    break;
                }
            }
            System.out.println("Масив спадає: " + isSorted);
        } else {
            System.out.println("Невірний вибір.");
        }
    }
}