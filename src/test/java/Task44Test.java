import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task44Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDetermineType1() {
        String arg = "123";
        String result = Task44.determineType(arg);
        assertEquals("Integer", result, "Аргумент має бути Integer");
    }

    @Test
    public void testDetermineType2() {
        String arg = "3.14";
        String result = Task44.determineType(arg);
        assertEquals("Real", result, "Аргумент має бути Real");
    }

    @Test
    public void testDetermineType3() {
        String arg = "'a'";
        String result = Task44.determineType(arg);
        assertEquals("Character", result, "Аргумент має бути Character");
    }

    @Test
    public void testDetermineType4() {
        String arg = "\"Hello\"";
        String result = Task44.determineType(arg);
        assertEquals("String", result, "Аргумент має бути String");
    }

    @Test
    public void testDetermineType5() {
        String arg = "test";
        String result = Task44.determineType(arg);
        assertEquals("Identifier", result, "Аргумент має бути Identifier");
    }

    @Test
    public void testDetermineType6() {
        String arg = "";
        String result = Task44.determineType(arg);
        assertEquals("Identifier", result, "Порожній аргумент має бути Identifier");
    }

    @Test
    public void testGetInputArguments() {
        String input = "test1\ntest2\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> arguments = Task44.getInputArguments();
        assertEquals(2, arguments.size(), "Має бути 2 аргументи");
        assertEquals("test1", arguments.get(0));
        assertEquals("test2", arguments.get(1));
    }

    @Test
    public void testAnalyzeAndPrintArguments() {
        List<String> arguments = List.of("123", "3.14", "'a'", "\"Hello\"", "test");

        Task44.analyzeAndPrintArguments(arguments);

        String lineSeparator = System.lineSeparator();
        String expectedOutput = "Кількість аргументів: 5" + lineSeparator +
                "Аргумент 1: тип = Integer, значення = 123" + lineSeparator +
                "Аргумент 2: тип = Real, значення = 3.14" + lineSeparator +
                "Аргумент 3: тип = Character, значення = 'a'" + lineSeparator +
                "Аргумент 4: тип = String, значення = \"Hello\"" + lineSeparator +
                "Аргумент 5: тип = Identifier, значення = test" + lineSeparator;

        assertEquals(expectedOutput, outContent.toString(), "Неправильне виведення аргументів");
    }
}