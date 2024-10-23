import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Аналіз типів аргументів, що задаються під час запуску програми. Якщо аргумент є числовим літералом, тобто
 * починається з цифри, то визначається його тип ( "Integer" або "Real"), якщо аргумент укладений в поодинокі апострофи
 * й містить один символ, то його тип - "Character", якщо аргумент укладений в подвійні апострофи, то його тип -
 * "String ". Якщо не одна з умов не виконується, то тип аргументу - "Identifier". Програма виводить кількість заданих
 * аргументів і, для кожного аргументу, його тип і значення.
 */
public class Task44 {
    public static void main(String[] args) {
        List<String> arguments = getInputArguments();
        analyzeAndPrintArguments(arguments);
    }

    protected static String determineType(String arg) {
        if (arg.matches("^\\d+$")) {
            return "Integer";
        } else if (arg.matches("^\\d*\\.\\d+$")) {
            return "Real";
        } else if (arg.matches("^'.'$")) {
            return "Character";
        } else if (arg.matches("^\".*\"$")) {
            return "String";
        } else {
            return "Identifier";
        }
    }

    protected static List<String> getInputArguments() {
        Scanner scanner = new Scanner(System.in);
        List<String> arguments = new ArrayList<>();

        System.out.println("Введіть аргументи. Введіть 'exit' для завершення введення:");
        while (true) {
            System.out.print("Введіть аргумент: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            arguments.add(input);
        }
        scanner.close();

        return arguments;
    }

    protected static void analyzeAndPrintArguments(List<String> arguments) {
        System.out.println("Кількість аргументів: " + arguments.size());

        for (int i = 0; i < arguments.size(); i++) {
            String arg = arguments.get(i);
            String type = determineType(arg);
            System.out.println("Аргумент " + (i + 1) + ": тип = " + type + ", значення = " + arg);
        }
    }
}