import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task24Test {
    @Test
    public void testAnalyzeArguments() {
        String[] args = {"if", "variable1", "123", "while", "$temp"};
        Task24.analyzeArguments(args);
    }

    @Test
    public void testAnalyzeArgument1() {
        String result = Task24.analyzeArgument("if");
        assertEquals("Keyword", result, "Повинно бути Keyword для 'if'");

        result = Task24.analyzeArgument("while");
        assertEquals("Keyword", result, "Повинно бути Keyword для 'while'");
    }

    @Test
    public void testAnalyzeArgument2() {
        String result = Task24.analyzeArgument("variable1");
        assertEquals("Identifier", result, "Повинно бути Identifier для 'variable1'");

        result = Task24.analyzeArgument("_tempVar");
        assertEquals("Identifier", result, "Повинно бути Identifier для '_tempVar'");

        result = Task24.analyzeArgument("$value");
        assertEquals("Identifier", result, "Повинно бути Identifier для '$value'");
    }

    @Test
    public void testAnalyzeArgument3() {
        String result = Task24.analyzeArgument("123abc");
        assertEquals("Illegal", result, "Повинно бути Illegal для '123abc'");

        result = Task24.analyzeArgument("var@name");
        assertEquals("Illegal", result, "Повинно бути Illegal для 'var@name'");

        result = Task24.analyzeArgument("");
        assertEquals("Illegal", result, "Повинно бути Illegal для порожнього рядка");
    }

    @Test
    public void testIsKeyword() {
        String result = Task24.analyzeArgument("for");
        assertEquals("Keyword", result, "Повинно бути Keyword для 'for'");

        result = Task24.analyzeArgument("abstract");
        assertEquals("Keyword", result, "Повинно бути Keyword для 'abstract'");
    }

    @Test
    public void testIsValidIdentifier() {
        String result = Task24.analyzeArgument("validVariable");
        assertEquals("Identifier", result, "Повинно бути Identifier для 'validVariable'");

        result = Task24.analyzeArgument("_anotherValidIdentifier");
        assertEquals("Identifier", result, "Повинно бути Identifier для '_anotherValidIdentifier'");

        result = Task24.analyzeArgument("$validWithDollar");
        assertEquals("Identifier", result, "Повинно бути Identifier для '$validWithDollar'");
    }

    @Test
    public void testInvalidIdentifiers() {
        String result = Task24.analyzeArgument("1variable");
        assertEquals("Illegal", result, "Повинно бути Illegal для '1variable'");

        result = Task24.analyzeArgument("var@name");
        assertEquals("Illegal", result, "Повинно бути Illegal для 'var@name'");
    }
}