package lab5;

/**
 * Карамельна цукерка (може бути без шоколаду).
 */
public class CaramelCandy extends Sweet {

    private final boolean hasChocolateGlaze;

    /**
     * @param name назва
     * @param weightGrams вага (г)
     * @param hasChocolateGlaze чи є шоколадна глазур
     */
    public CaramelCandy(String name, double weightGrams, boolean hasChocolateGlaze) {
        super(name, weightGrams);
        this.hasChocolateGlaze = hasChocolateGlaze;
    }

    public boolean hasChocolateGlaze() {
        return hasChocolateGlaze;
    }

    @Override
    public int getChocolatePercent() {
        // Спрощено: якщо є глазур — умовно 20%, якщо нема — 0%.
        return hasChocolateGlaze ? 20 : 0;
    }
}
