package lab5;

/**
 * Абстрактний базовий клас для всіх солодощів.
 * Містить спільні поля та методи.
 */
public abstract class Sweet {

    private final String name;
    private final double weightGrams;

    /**
     * @param name назва солодощів
     * @param weightGrams вага в грамах (має бути > 0)
     */
    protected Sweet(String name, double weightGrams) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва не може бути порожньою.");
        }
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Вага має бути більшою за 0.");
        }
        this.name = name;
        this.weightGrams = weightGrams;
    }

    public String getName() {
        return name;
    }

    public double getWeightGrams() {
        return weightGrams;
    }

    /**
     * Вміст шоколаду у відсотках (0..100).
     * Для солодощів без шоколаду повертаємо 0.
     */
    public abstract int getChocolatePercent();

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{name='" + name + '\''
                + ", weightGrams=" + weightGrams
                + ", chocolatePercent=" + getChocolatePercent()
                + "}";
    }
}
