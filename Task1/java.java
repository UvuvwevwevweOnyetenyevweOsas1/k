import java.util.Scanner;

public class java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть x: ");
        double x = sc.nextDouble();

        System.out.print("Введіть a: ");
        double a = sc.nextDouble();

        System.out.print("Введіть b: ");
        double b = sc.nextDouble();

        double f;

        if (x >= 1 && x < 3) {
            f = 9;
        } else if (x == 3) {
            f = a * x * x + x + b;
        } else {
            f = a * x;
        }

        System.out.println("f(x) = " + f);
    }
}
