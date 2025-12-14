import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє текст як масив речень.
 */
public class Text {

    private List<Sentence> sentences = new ArrayList<>();

    /**
     * Конструктор тексту.
     *
     * @param text вхідний текст
     */
    public Text(String text) {
        normalizeSpaces(text);
    }

    /**
     * Нормалізація пробілів і табуляцій.
     *
     * @param text вхідний текст
     */
    private void normalizeSpaces(String text) {
        String normalized = text.replaceAll("[\\t\\s]+", " ");
        for (String s : normalized.split("\\.")) {
            sentences.add(new Sentence(s));
        }
    }

    /**
     * Видалити підрядки у всіх реченнях.
     *
     * @param start початкова літера
     * @param end   кінцева літера
     */
    public void process(char start, char end) {
        for (Sentence sentence : sentences) {
            sentence.removeLongestSubstring(start, end);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Sentence sentence : sentences) {
            builder.append(sentence).append(". ");
        }
        return builder.toString().trim();
    }
}
