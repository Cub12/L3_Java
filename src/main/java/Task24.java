import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Аналіз типів аргументів, що задаються під час запуску програми. Якщо аргумент є правильним ідентифікатором Java
 * (шаблон: складається з латинських букв, цифр і символів "$" і "_", що вважаються буквами, і, крім того, перший
 * символ є літерою), то його тип "Identifier", якщо аргумент є ключовим словом Java (для прикладу задати кілька
 * ключових слів Java, "if", "for", "while", "do" і "else"), то його тип "Keyword", інакше його тип вважається
 * "Illegal". Програма виводить кількість заданих аргументів і для кожного аргументу його тип і значення.
 */
public class Task24 {
    public static void main(String[] args) {
        analyzeArguments(args);
    }

    private static final Set<String> KEYWORDS = new HashSet<>();

    static {
        String[] keywordsArray = {
                "abstract", "assert", "boolean", "break", "byte",
                "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else",
                "enum", "extends", "final", "finally", "float",
                "for", "goto", "if", "implements", "import",
                "instanceof", "int", "interface", "long", "native",
                "new", "null", "package", "private", "protected",
                "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw",
                "throws", "transient", "try", "void", "volatile",
                "while"
        };

        Collections.addAll(KEYWORDS, keywordsArray);
    }

    protected static void analyzeArguments(String[] args) {
        System.out.println("Number of arguments: " + args.length);

        for (String arg : args) {
            String type = analyzeArgument(arg);
            System.out.println("Аргумент: '" + arg + "' має тип: " + type);
        }
    }

    protected static String analyzeArgument(String arg) {
        if (isKeyword(arg)) {
            return "Keyword";
        }

        if (isValidIdentifier(arg)) {
            return "Identifier";
        }

        return "Illegal";
    }

    private static boolean isKeyword(String arg) {
        return KEYWORDS.contains(arg);
    }

    private static boolean isValidIdentifier(String arg) {
        if (arg.isEmpty() || !Character.isJavaIdentifierStart(arg.charAt(0))) {
            return false;
        }

        for (int i = 1; i < arg.length(); i++) {
            if (!Character.isJavaIdentifierPart(arg.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}