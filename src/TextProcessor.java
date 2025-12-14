/**
 * Виконавчий клас лабораторної роботи №4.
 */
public class TextProcessor {

    public static void main(String[] args) {
        try {
            String inputText = "abXYZba   test\t\tab12345ba.   Another   abXXba   sentence.";
            char startChar = 'a';
            char endChar = 'b';

            Text text = new Text(inputText);
            text.process(startChar, endChar);

            System.out.println("Результат обробки тексту:");
            System.out.println(text);

        } catch (Exception e) {
            System.out.println("Помилка під час обробки тексту: " + e.getMessage());
        }
    }
}