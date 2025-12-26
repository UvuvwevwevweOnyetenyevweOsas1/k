import java.util.Scanner;

public class java3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть N: ");
        int N = sc.nextInt();

        System.out.println("Прості числа від 1 до " + N + ":");

        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
}
