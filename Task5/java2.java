import java.util.Scanner;

public class java2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок: ");
        String input = scanner.nextLine();

        String result = new StringBuilder(input).reverse().toString();

        System.out.println("Інвертований рядок: " + result);
    }
}