public class java {
    public static void main(String[] args) {
        // Константи згідно з варіантом 2
        double a = 2.953;
        double b = 0.254;
        double c = 0.5;

        // Розрахунок x = 2^(b^4) + (3^a)^b
        double x = Math.pow(2, Math.pow(b, 4)) + Math.pow(Math.pow(3, a), b);

        // Розрахунок y
        // Чисельник: |a - b| * (1 + (sin^2(c) / (a + b)))
        double numerator = Math.abs(a - b) * (1 + (Math.pow(Math.sin(c), 2) / (a + b)));
        
        // Знаменник: e^|a - b| + a/2
        double denominator = Math.exp(Math.abs(a - b)) + (a / 2);
        
        double y = numerator / denominator;

        System.out.printf("Результати для Завдання 1:%n");
        System.out.printf("x = %.4f%n", x);
        System.out.printf("y = %.4f%n", y);
    }
}