import java.util.Scanner;

public class java {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userString = inputValidString(scanner);

        System.out.println("\nОберіть дію:");
        System.out.println("2 - Перевернути весь рядок повністю");
        System.out.println("3 - Перевернути кожне слово в рядку окремо");
        
        int choice = scanner.nextInt();

        if (choice == 2) {
            String result = reverseFullString(userString);
            System.out.println("Результат: " + result);
        } else if (choice == 3) {
            String result = reverseEachWord(userString);
            System.out.println("Результат: " + result);
        } else {
            System.out.println("Невірний вибір.");
        }

        scanner.close();
    }


    public static String inputValidString(Scanner scanner) {
        String input;
        boolean isValid;
        do {
            isValid = true;
            System.out.println("Введіть рядок (мінімум 2 слова, кожне слово від 3 символів):");
            input = scanner.nextLine().trim();

            String[] words = input.split("\\s+");

            if (words.length < 2) {
                System.out.println("Помилка: має бути хоча б 2 слова.");
                isValid = false;
            } else {

                for (String word : words) {
                    if (word.length() < 3) {
                        System.out.println("Помилка: слово '" + word + "' занадто коротке (мінімум 3 символи).");
                        isValid = false;
                        break;
                    }
                }
            }
        } while (!isValid);
        
        return input;
    }


    public static String reverseFullString(String str) {
        return new StringBuilder(str).reverse().toString();
    }


    public static String reverseEachWord(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            result.append(reversedWord);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}