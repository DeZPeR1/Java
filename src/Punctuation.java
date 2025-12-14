/**
 * Клас, що представляє розділовий знак.
 */
public class Punctuation {

    private char value;

    /**
     * Конструктор розділового знаку.
     *
     * @param value символ
     */
    public Punctuation(char value) {
        this.value = value;
    }

    /**
     * Отримати символ розділового знаку.
     *
     * @return символ
     */
    public char getValue() {
        return value;
    }
}
