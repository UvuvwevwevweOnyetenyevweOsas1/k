import java.util.Scanner;

public class java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("byte, int, double, boolean, char");
        System.out.print("Введіть тип даних: ");
        String type = sc.nextLine();

        System.out.print("Введіть значення: ");
        String input = sc.nextLine();

        if (type.equals("byte")) {
            byte value = Byte.parseByte(input);
            System.out.println("byte: " + value);
        } else if (type.equals("int")) {
            int value = Integer.parseInt(input);
            System.out.println("int: " + value);
        } else if (type.equals("double")) {
            double value = Double.parseDouble(input);
            System.out.println("double: " + value);
        } else if (type.equals("boolean")) {
            boolean value = Boolean.parseBoolean(input);
            System.out.println("boolean: " + value);
        } else if (type.equals("char")) {
            char value = input.charAt(0);
            System.out.println("char: " + value);
        } else {
            System.out.println("Невідомий тип");
        }
    }
}