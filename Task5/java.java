import java.util.Scanner;

public class java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок для перевірки на паліндром:");
        String original = scanner.nextLine();

        String cleanStr = original.replaceAll("\\s+", "").toLowerCase();

        String reversed = new StringBuilder(cleanStr).reverse().toString();

        if (cleanStr.equals(reversed)) {
            System.out.println("Цей рядок є паліндромом.");
        } else {
            System.out.println("Цей рядок НЕ є паліндромом.");
        }
    }
}