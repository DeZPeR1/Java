package lab5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Узагальнений клас "Дитячий подарунок".
 * Зберігає масив солодощів та дозволяє виконувати операції:
 * - додавання
 * - підрахунок ваги
 * - сортування
 * - пошук за діапазоном вмісту шоколаду
 *
 * @param <T> тип солодощів, що наслідує Sweet
 */
public class Gift<T extends Sweet> {

    private final T[] items;
    private int size;

    /**
     * @param capacity максимальна кількість солодощів у подарунку
     */
    @SuppressWarnings("unchecked")
    public Gift(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість подарунка має бути більшою за 0.");
        }
        this.items = (T[]) new Sweet[capacity];
        this.size = 0;
    }

    /**
     * Додати солодкість у подарунок.
     *
     * @param item солодкість
     */
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Не можна додати null у подарунок.");
        }
        if (size >= items.length) {
            throw new IllegalStateException("Подарунок переповнений. Неможливо додати більше солодощів.");
        }
        items[size] = item;
        size++;
    }

    /**
     * Порахувати загальну вагу подарунка (в грамах).
     *
     * @return сумарна вага
     */
    public double getTotalWeightGrams() {
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += items[i].getWeightGrams();
        }
        return sum;
    }

    /**
     * Відсортувати солодощі за переданим компаратором.
     *
     * @param comparator правило сортування
     */
    public void sort(Comparator<? super T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator не може бути null.");
        }
        Arrays.sort(items, 0, size, comparator);
    }

    /**
     * Знайти першу солодкість, у якої вміст шоколаду у заданому діапазоні.
     *
     * @param minPercent мінімальний % (0..100)
     * @param maxPercent максимальний % (0..100)
     * @return знайдена солодкість або null, якщо нічого не знайдено
     */
    public T findByChocolateRange(int minPercent, int maxPercent) {
        if (minPercent < 0 || maxPercent > 100 || minPercent > maxPercent) {
            throw new IllegalArgumentException("Некоректний діапазон шоколаду. Очікується 0..100 та min<=max.");
        }

        for (int i = 0; i < size; i++) {
            int chocolate = items[i].getChocolatePercent();
            if (chocolate >= minPercent && chocolate <= maxPercent) {
                return items[i];
            }
        }
        return null;
    }

    /**
     * Отримати копію масиву фактичних елементів (без порожніх місць).
     *
     * @return масив солодощів розміром size
     */
    public T[] toArray() {
        return Arrays.copyOf(items, size);
    }
}
