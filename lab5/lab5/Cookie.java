package lab5;

/**
 * Печиво (інші солодощі).
 */
public class Cookie extends Sweet {

    private final boolean withChocolateChips;

    /**
     * @param name назва
     * @param weightGrams вага (г)
     * @param withChocolateChips чи є шоколадні крихти
     */
    public Cookie(String name, double weightGrams, boolean withChocolateChips) {
        super(name, weightGrams);
        this.withChocolateChips = withChocolateChips;
    }

    @Override
    public int getChocolatePercent() {
        // Спрощено: з крихтами — 10%, без — 0%.
        return withChocolateChips ? 10 : 0;
    }
}
