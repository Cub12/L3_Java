import java.util.Scanner;

/**
 * Створіть програму для визначення кількості входжень зазначеного символу в заданому тексті. Робота програми
 * припиняється після введення символу "-".
 */
public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String text = getInputText(scanner);
            if (text.equals("-")) {
                System.out.println("Програма завершена.");
                break;
            }

            char characterToCount = getCharacterToCount(scanner);
            int count = countCharacterOccurrences(text, characterToCount);

            System.out.println("Кількість входжень символу '" + characterToCount + "' у тексті: " + count);
        }
        scanner.close();
    }

    protected static int countCharacterOccurrences(String text, char character) {
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (ch == character) {
                count++;
            }
        }

        return count;
    }

    protected static String getInputText(Scanner scanner) {
        System.out.print("Введіть текст (або '-' для виходу): ");
        return scanner.nextLine();
    }

    protected static char getCharacterToCount(Scanner scanner) {
        while (true) {
            System.out.print("Введіть символ для підрахунку входжень: ");
            String inputChar = scanner.nextLine();

            if (inputChar.length() != 1) {
                System.out.println("Будь ласка, введіть лише один символ.");
                continue;
            }

            return inputChar.charAt(0);
        }
    }
}