public class java2 {
    public static void main(String[] args) {

        int[] angles = {90, 90, 90, 90}; 
        
        int n = angles.length; 
        int sum = 0;

        for (int angle : angles) {
            sum += angle;
        }

        int requiredSum = 180 * (n - 2);

        System.out.println("Кількість кутів: " + n);
        System.out.println("Сума кутів масиву: " + sum);
        System.out.println("Необхідна сума: " + requiredSum);

        if (sum == requiredSum && n > 2) {
            System.out.println("Такий багатокутник може існувати.");
        } else {
            System.out.println("Такий багатокутник НЕ може існувати.");
        }
    }
}