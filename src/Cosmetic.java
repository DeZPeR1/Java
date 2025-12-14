import java.util.Arrays;
import java.util.Comparator;

/**
 * Лабораторна робота №3.
 * Клас демонструє роботу з масивом об'єктів,
 * сортування за двома полями та пошук ідентичного об'єкта.
 */

public class Cosmetic {

    // Назва косметичного засобу
    private String name;

    // Бренд косметичного засобу
    private String brand;

    // Ціна косметичного засобу
    private double price;

    // Рейтинг користувачів
    private int rating;

    // Обʼєм у мілілітрах
    private int volume;

    /**
     * Конструктор класу Cosmetic.
     *
     * @param name   назва косметичного засобу
     * @param brand  бренд
     * @param price  ціна
     * @param rating рейтинг
     * @param volume обʼєм у мл
     */
    public Cosmetic(String name, String brand, double price, int rating, int volume) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
        this.volume = volume;
    }

    /**
     * Виконавчий метод програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {

        // Створення масиву об'єктів класу Cosmetic
        Cosmetic[] cosmetics = {
                new Cosmetic("Cream", "Nivea", 120.0, 4, 100),
                new Cosmetic("Shampoo", "Head&Shoulders", 200.0, 5, 250),
                new Cosmetic("Perfume", "Chanel", 120.0, 5, 50),
                new Cosmetic("Lotion", "Dove", 150.0, 3, 200),
                new Cosmetic("Serum", "The Ordinary", 200.0, 4, 30)
        };

        // Сортування масиву:
        // 1) за ціною у порядку зростання
        // 2) за рейтингом у порядку спадання, якщо ціни однакові
        Arrays.sort(cosmetics, Comparator
                .comparingDouble(Cosmetic::getPrice)
                .thenComparing(Comparator.comparingInt(Cosmetic::getRating).reversed())
        );

        // Виведення відсортованого масиву
        System.out.println("Відсортований список косметики:");
        for (Cosmetic cosmetic : cosmetics) {
            System.out.println(cosmetic);
        }

        // Об'єкт, який необхідно знайти в масиві
        Cosmetic target = new Cosmetic("Perfume", "Chanel", 120.0, 5, 50);

        // Пошук ідентичного об'єкта
        boolean found = false;
        for (Cosmetic cosmetic : cosmetics) {
            if (cosmetic.equals(target)) {
                found = true;
                System.out.println("\nІдентичний об'єкт знайдено:");
                System.out.println(cosmetic);
                break;
            }
        }

        // Повідомлення, якщо об'єкт не знайдено
        if (!found) {
            System.out.println("\nІдентичний об'єкт не знайдено.");
        }
    }

    /**
     * Отримати ціну косметичного засобу.
     *
     * @return ціна
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримати рейтинг косметичного засобу.
     *
     * @return рейтинг
     */
    public int getRating() {
        return rating;
    }

    /**
     * Перевизначення методу equals для порівняння обʼєктів.
     *
     * @param obj обʼєкт для порівняння
     * @return true, якщо обʼєкти ідентичні
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cosmetic)) {
            return false;
        }

        Cosmetic other = (Cosmetic) obj;

        return name.equals(other.name)
                && brand.equals(other.brand)
                && Double.compare(price, other.price) == 0
                && rating == other.rating
                && volume == other.volume;
    }

    /**
     * Повертає рядкове представлення об'єкта Cosmetic.
     *
     * @return рядок з інформацією про косметичний засіб
     */
    @Override
    public String toString() {
        return "Cosmetic{"
                + "name='" + name + '\''
                + ", brand='" + brand + '\''
                + ", price=" + price
                + ", rating=" + rating
                + ", volume=" + volume
                + '}';
    }
}
