import java.util.Random;
import java.util.Scanner;

public class java3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.print("Згенерований масив: ");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Яке число замінити? ");
        int target = scanner.nextInt();
        
        System.out.print("На яке число замінити? ");
        int replacement = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                arr[i] = replacement;
                found = true;
            }
        }

        if (found) {
            System.out.print("Оновлений масив: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Число " + target + " не знайдено в масиві.");
        }
    }
}