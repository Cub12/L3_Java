import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @Test
    public void testProcessText1() {
        String input = "hello";
        int key = 3;
        String expected = "khoor";
        String result = Task5.processText(input, key, true);
        assertEquals(expected, result);
    }

    @Test
    public void testProcessText2() {
        String input = "khoor";
        int key = 3;
        String expected = "hello";
        String result = Task5.processText(input, key, false);
        assertEquals(expected, result);
    }

    @Test
    public void testProcessText3() {
        String input = "hello";
        int key = -3;
        String expected = "ebiil";
        String result = Task5.processText(input, key, true);
        assertEquals(expected, result);
    }

    @Test
    public void testProcessText4() {
        String input = "ebiil";
        int key = -3;
        String expected = "hello";
        String result = Task5.processText(input, key, false);
        assertEquals(expected, result);
    }

    @Test
    public void testProcessText5() {
        String input = "";
        int key = 3;
        String expected = "";
        String result = Task5.processText(input, key, true);
        assertEquals(expected, result);
    }

    @Test
    public void testProcessText6() {
        String input = "";
        int key = 3;
        String expected = "";
        String result = Task5.processText(input, key, false);
        assertEquals(expected, result);
    }

    @Test
    public void testProcessText7() {
        String input = "hello";
        int key = 0;
        String expected = "hello";
        String result = Task5.processText(input, key, true);
        assertEquals(expected, result);
    }

    @Test
    public void testInputText() {
        String inputText = "test text";
        InputStream stdin = System.in;

        try {
            System.setIn(new ByteArrayInputStream(inputText.getBytes()));
            Scanner scanner = new Scanner(System.in);
            String result = Task5.inputText(scanner);
            assertEquals(inputText, result);
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void testInputKey() {
        String inputKey = "5\n";
        InputStream stdin = System.in;

        try {
            System.setIn(new ByteArrayInputStream(inputKey.getBytes()));
            Scanner scanner = new Scanner(System.in);
            int result = Task5.inputKey(scanner);
            assertEquals(5, result);
        } finally {
            System.setIn(stdin);
        }
    }
}