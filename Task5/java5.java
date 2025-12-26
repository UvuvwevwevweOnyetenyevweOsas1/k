import java.util.Scanner;

public class java5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] forbiddenWords = {"бяка", "поганий", "дурень"};

        System.out.println("Введіть текст:");
        String text = scanner.nextLine();

        String censoredText = text;

        for (String word : forbiddenWords) {

            censoredText = censoredText.replaceAll("(?i)\\b" + word + "\\b", "***");
        }

        System.out.println("Текст після цензури:");
        System.out.println(censoredText);
    }
}