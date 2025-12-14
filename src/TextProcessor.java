public class TextProcessor {

    public static void main(String[] args) {
        try {
            // Вхідний текст (дозволено String для введення)
            String inputText = "abXYZba test ab12345ba. Another abXXba sentence.";

            // Задані літери
            char startChar = 'a';
            char endChar = 'b';

            // Перетворення в StringBuilder для обробки
            StringBuilder textBuilder = new StringBuilder(inputText);

            StringBuilder resultText = new StringBuilder();

            int sentenceStart = 0;

            for (int i = 0; i <= textBuilder.length(); i++) {
                if (i == textBuilder.length() || textBuilder.charAt(i) == '.') {

                    StringBuilder sentence = new StringBuilder(
                            textBuilder.substring(sentenceStart, i)
                    );

                    int maxLength = 0;
                    int deleteStart = -1;
                    int deleteEnd = -1;

                    for (int j = 0; j < sentence.length(); j++) {
                        if (sentence.charAt(j) == startChar) {
                            for (int k = j + 1; k < sentence.length(); k++) {
                                if (sentence.charAt(k) == endChar) {
                                    int length = k - j + 1;
                                    if (length > maxLength) {
                                        maxLength = length;
                                        deleteStart = j;
                                        deleteEnd = k + 1;
                                    }
                                }
                            }
                        }
                    }

                    if (deleteStart != -1) {
                        sentence.delete(deleteStart, deleteEnd);
                    }

                    resultText.append(sentence);

                    if (i < textBuilder.length()) {
                        resultText.append(".");
                    }

                    sentenceStart = i + 1;
                }
            }

            // Виведення результату (дозволено String)
            System.out.println("Результат обробки тексту:");
            System.out.println(resultText.toString());

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Помилка роботи з індексами рядка");
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        }
    }
}
