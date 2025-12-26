import java.util.Random;
import java.util.Scanner;

public class java2 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int secret = random.nextInt(100) + 1; // число від 1 до 100
        int guess;
        int attempts = 0;

        do {
            System.out.print("Вгадайте число (1-100): ");
            guess = sc.nextInt();
            attempts++;

            if (guess > secret) {
                System.out.println("Загадане число менше");
            } else if (guess < secret) {
                System.out.println("Загадане число більше");
            }
        } while (guess != secret);

        System.out.println("Ви вгадали число!");
        System.out.println("Кількість спроб: " + attempts);
    }
}
