package lab5;

import java.util.Comparator;

/**
 * Виконавчий клас лабораторної роботи №5.
 */
public class App {

    public static void main(String[] args) {
        try {
            // Створюємо кілька об'єктів-цукерок/солодощів
            lab5.ChocolateCandy c1 = new ChocolateCandy("Truffle", 15.5, 60, "Какао-крем");
            ChocolateCandy c2 = new ChocolateCandy("Cherry", 18.0, 40, "Вишня");
            CaramelCandy c3 = new CaramelCandy("Barbaris", 8.0, false);
            CaramelCandy c4 = new CaramelCandy("Toffee", 12.0, true);
            Cookie s1 = new Cookie("Cookie Classic", 25.0, true);

            // Створюємо подарунок (узагальнений клас + масив)
            Gift<Sweet> gift = new Gift<>(10);

            // Збираємо дитячий подарунок
            gift.add(c1);
            gift.add(c2);
            gift.add(c3);
            gift.add(c4);
            gift.add(s1);

            // Визначаємо вагу подарунку
            double totalWeight = gift.getTotalWeightGrams();
            System.out.println("Загальна вага подарунка (г): " + totalWeight);

            // Сортування цукерок у подарунку за одним параметром (наприклад, за вагою за зростанням)
            gift.sort(Comparator.comparingDouble(Sweet::getWeightGrams));

            System.out.println("\nПодарунок після сортування за вагою (зростання):");
            for (Sweet item : gift.toArray()) {
                System.out.println(item);
            }

            // Пошук цукерки за діапазоном вмісту шоколаду
            int minChocolate = 30;
            int maxChocolate = 60;

            Sweet found = gift.findByChocolateRange(minChocolate, maxChocolate);

            System.out.println("\nПошук за діапазоном шоколаду " + minChocolate + "%.." + maxChocolate + "%:");
            if (found != null) {
                System.out.println("Знайдено: " + found);
            } else {
                System.out.println("Нічого не знайдено у вказаному діапазоні.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення/параметрів: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Помилка стану програми: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        }
    }
}
