import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє слово як масив літер.
 */
public class Word {

    private List<Letter> letters = new ArrayList<>();

    /**
     * Конструктор слова з рядка.
     *
     * @param text текст слова
     */
    public Word(String text) {
        for (char c : text.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Перетворити слово у String.
     *
     * @return рядкове представлення слова
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Letter letter : letters) {
            builder.append(letter.getValue());
        }
        return builder.toString();
    }
}
