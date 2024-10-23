import java.util.Scanner;

/**
 * Створіть програму для шифрування\розшифровки тексту методом Цезаря. У ньому ключем є ціле число,
 * а шифрування\розшифровка полягає в сумуванні\відніманні кодів символів відкритого тексту\криптотексту з ключем.
 */
public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = inputText(scanner);
        int key = inputKey(scanner);
        boolean encrypt = chooseOperation(scanner);

        String processedText = processText(text, key, encrypt);

        if (encrypt) {
            System.out.println("Зашифрований текст: " + processedText);
        } else {
            System.out.println("Розшифрований текст: " + processedText);
        }

        scanner.close();
    }

    public static String processText(String text, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            char processedChar = (char) (ch + (encrypt ? key : -key));
            result.append(processedChar);
        }

        return result.toString();
    }

    public static String normalizeLineEndings(String input) {
        return input.replace("\r\n", "\n").replace("\r", "\n");
    }

    public static String inputText(Scanner scanner) {
        System.out.print("Введіть текст: ");
        String input = scanner.nextLine();
        return normalizeLineEndings(input);
    }

    public static int inputKey(Scanner scanner) {
        int key = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введіть ключ (ціле число): ");
            try {
                key = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Помилка: будь ласка, введіть ціле число.");
                scanner.next();
            }
        }

        return key;
    }

    public static boolean chooseOperation(Scanner scanner) {
        while (true) {
            System.out.print("Оберіть операцію (1 - зашифрувати, 2 - розшифрувати): ");
            String choice = scanner.next();

            if (choice.equals("1")) {
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                System.out.println("Помилка: введіть 1 або 2.");
            }
        }
    }
}