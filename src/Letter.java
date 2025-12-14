/**
 * Клас, що представляє окрему літеру.
 */
public class Letter {

    private char value;

    /**
     * Конструктор літери.
     *
     * @param value символ літери
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Отримати значення літери.
     *
     * @return символ
     */
    public char getValue() {
        return value;
    }
}
