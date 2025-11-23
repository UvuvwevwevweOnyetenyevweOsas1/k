import java.util.Scanner;

public class java2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть ціле число: ");
        int num = sc.nextInt();

        System.out.print("Введіть число з плаваючою крапкою: ");
        double dbl = sc.nextDouble();
        sc.nextLine();

        System.out.print("Введіть рядок: ");
        String str = sc.nextLine();

        System.out.print("Введіть логічне значення (true/false): ");
        boolean bool = sc.nextBoolean();

        System.out.println("\n--- Виведення у різних форматах ---");

        System.out.println("1. Ціле число (десяткова система): " + num);
        System.out.println("2. Ціле число (шістнадцяткова система): " + Integer.toHexString(num));
        System.out.println("3. Ціле число (вісімкова система): " + Integer.toOctalString(num));
        System.out.println("4. Число з плаваючою крапкою (2 знаки): " + String.format("%.2f", dbl));
        System.out.println("5. Число з плаваючою крапкою (науковий формат): " + String.format("%.4e", dbl));
        System.out.println("6. Рядок у лапках: \"" + str + "\"");
        System.out.println("7. Рядок довжиною 10 символів: " + String.format("%-10s", str));
        System.out.println("8. Логічне значення (true/false): " + bool);
        System.out.println("9. Логічне значення (1 або 0): " + (bool ? 1 : 0));
        System.out.println("10. Комбінований вивід: " + num + " " + String.format("%.2f", dbl) + " " + str + " " + bool);
    }
}