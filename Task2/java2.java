import java.util.Scanner;

public class java2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть значення a: ");
        double a = input.nextDouble();
        
        System.out.print("Введіть значення b: ");
        double b = input.nextDouble();
        
        System.out.print("Введіть значення x: ");
        double x = input.nextDouble();

        double f_x;

        // Логіка розгалуження
        if (x >= 0 && x < 9) {
            // x ∈ [0, 9)
            f_x = Math.cos(x);
            System.out.printf("f(x) = cos(x) = %.4f%n", f_x);
        } 
        else if (x == 9) {
            // x = 9
            f_x = 3 * Math.exp(a * x) + 1;
            System.out.printf("f(x) = 3*e^(ax) + 1 = %.4f%n", f_x);
        } 
        else if (x > 9 && x < 11) {
            // x ∈ (9, 11)
            double arg = b * x - 1;
            if (arg > 0) {
                f_x = Math.log(arg); // ln у Java це Math.log
                System.out.printf("f(x) = ln(bx - 1) = %.4f%n", f_x);
            } else {
                System.out.println("Помилка: аргумент логарифма <= 0");
            }
        } 
        else {
            System.out.println("Значення x поза межами визначених діапазонів.");
        }

        input.close();
    }
}