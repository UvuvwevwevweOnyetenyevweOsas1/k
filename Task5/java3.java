import java.util.Scanner;

public class java3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть речення:");
        String text = scanner.nextLine();


        String[] words = text.trim().split("\\s+");

        if (words.length == 0 || text.isEmpty()) {
            System.out.println("Слів не знайдено.");
            return;
        }

        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        System.out.println("Найменше слово: \"" + shortest + "\" (довжина: " + shortest.length() + ")");
        System.out.println("Найдовше слово: \"" + longest + "\" (довжина: " + longest.length() + ")");
    }
}