package lab5;

/**
 * Цукерка з шоколадом.
 */
public class ChocolateCandy extends Sweet {

    private final int chocolatePercent;
    private final String filling;

    /**
     * @param name назва
     * @param weightGrams вага (г)
     * @param chocolatePercent вміст шоколаду (0..100)
     * @param filling начинка
     */
    public ChocolateCandy(String name, double weightGrams, int chocolatePercent, String filling) {
        super(name, weightGrams);

        if (chocolatePercent < 0 || chocolatePercent > 100) {
            throw new IllegalArgumentException("Вміст шоколаду має бути в межах 0..100.");
        }
        if (filling == null || filling.isBlank()) {
            throw new IllegalArgumentException("Начинка не може бути порожньою.");
        }

        this.chocolatePercent = chocolatePercent;
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    @Override
    public int getChocolatePercent() {
        return chocolatePercent;
    }
}
