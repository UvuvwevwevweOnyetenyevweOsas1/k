public class java4 {
    public static void main(String[] args) {
        System.out.println("Таблиця синусів від 0 до 90 градусів:");
        
        int count = 0;
        for (int degree = 0; degree <= 90; degree++) {
            double radians = Math.toRadians(degree);
            double sinValue = Math.sin(radians);
 
            System.out.printf("sin(%2d)=%.3f  ", degree, sinValue);
            count++;

            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }
}