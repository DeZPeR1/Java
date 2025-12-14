import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє речення як масив слів та розділових знаків.
 */
public class Sentence {

    private List<Object> elements = new ArrayList<>();

    /**
     * Конструктор речення з рядка.
     *
     * @param text текст речення
     */
    public Sentence(String text) {
        parse(text);
    }

    /**
     * Парсинг рядка у слова та розділові знаки.
     *
     * @param text текст речення
     */
    private void parse(String text) {
        StringBuilder buffer = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                buffer.append(c);
            } else {
                if (buffer.length() > 0) {
                    elements.add(new Word(buffer.toString()));
                    buffer.setLength(0);
                }
                if (!Character.isWhitespace(c)) {
                    elements.add(new Punctuation(c));
                }
            }
        }

        if (buffer.length() > 0) {
            elements.add(new Word(buffer.toString()));
        }
    }

    /**
     * Видалити найдовший підрядок, що починається і закінчується заданими літерами.
     *
     * @param start початкова літера
     * @param end   кінцева літера
     */
    public void removeLongestSubstring(char start, char end) {
        StringBuilder sentenceText = new StringBuilder(toString());

        int maxLength = 0;
        int deleteStart = -1;
        int deleteEnd = -1;

        for (int i = 0; i < sentenceText.length(); i++) {
            if (sentenceText.charAt(i) == start) {
                for (int j = i + 1; j < sentenceText.length(); j++) {
                    if (sentenceText.charAt(j) == end) {
                        int length = j - i + 1;
                        if (length > maxLength) {
                            maxLength = length;
                            deleteStart = i;
                            deleteEnd = j + 1;
                        }
                    }
                }
            }
        }

        if (deleteStart != -1) {
            sentenceText.delete(deleteStart, deleteEnd);
        }

        elements.clear();
        parse(sentenceText.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object obj : elements) {
            builder.append(obj.toString());
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
