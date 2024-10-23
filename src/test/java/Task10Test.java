import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task10Test {
    @Test
    public void testCountCharacterOccurrences() {
        String text = "hello world";

        assertEquals(3, Task10.countCharacterOccurrences(text, 'l'));
        assertEquals(2, Task10.countCharacterOccurrences(text, 'o'));
        assertEquals(0, Task10.countCharacterOccurrences(text, 'z'));
        assertEquals(0, Task10.countCharacterOccurrences("", 'a'));
        assertEquals(1, Task10.countCharacterOccurrences("a", 'a'));
        assertEquals(5, Task10.countCharacterOccurrences("aaaaa", 'a'));
    }

    @Test
    public void testGetInputText() {
        String input = "Test text\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        String result = Task10.getInputText(scanner);

        assertEquals("Test text", result);
    }

    @Test
    public void testGetCharacterToCount1() {
        String input = "a\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        char result = Task10.getCharacterToCount(scanner);

        assertEquals('a', result);
    }

    @Test
    public void testGetCharacterToCount2() {
        String input = "invalid\nb\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        char result = Task10.getCharacterToCount(scanner);

        assertEquals('b', result);
    }
}