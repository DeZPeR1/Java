import java.util.List;

/**
 * Entry point for Lab 6 demonstration.
 */
public class Main {

    public static void main(String[] args) {

        // Дані з Lab5 (StringBuilder)
        StringBuilder sb1 = new StringBuilder("hello");
        StringBuilder sb2 = new StringBuilder("world");
        StringBuilder sb3 = new StringBuilder("hello");

        // 1. Порожній конструктор
        StringBuilderSet set1 = new StringBuilderSet();
        set1.add(sb1);
        set1.add(sb2);
        set1.add(sb3); // не додасться (дублікат)

        // 2. Конструктор з одним об'єктом
        StringBuilderSet set2 = new StringBuilderSet(new StringBuilder("single"));

        // 3. Конструктор зі стандартною колекцією
        StringBuilderSet set3 = new StringBuilderSet(
                List.of(
                        new StringBuilder("A"),
                        new StringBuilder("B"),
                        new StringBuilder("A")
                )
        );

        System.out.println("Set1 size: " + set1.size());
        System.out.println("Set2 contains 'single': " +
                set2.contains(new StringBuilder("single")));

        System.out.println("Set3 elements:");
        for (StringBuilder sb : set3) {
            System.out.println(sb);
        }
    }
}
