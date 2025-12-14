public class MatrixOperations {

    public static void main(String[] args) {
        try {
            // Задання розмірів матриць
            int rows = 4;
            int cols = 3;

            // Ініціалізація матриць A і B
            byte[][] matrixA = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {10, 11, 12}
            };

            byte[][] matrixB = {
                    {1, 1, 1},
                    {1, 1, 1},
                    {1, 1, 1},
                    {1, 1, 1}
            };

            // Перевірка коректності розмірів
            if (matrixA.length != rows || matrixB.length != rows) {
                throw new IllegalArgumentException("Невірна кількість рядків у матрицях");
            }

            // Обчислення матриці C = A + B
            byte[][] matrixC = new byte[rows][cols];

            for (int i = 0; i < rows; i++) {
                if (matrixA[i].length != cols || matrixB[i].length != cols) {
                    throw new IllegalArgumentException("Невірна кількість стовпців у матрицях");
                }

                for (int j = 0; j < cols; j++) {
                    matrixC[i][j] = (byte) (matrixA[i][j] + matrixB[i][j]);
                }
            }

            // Обчислення суми
            int sum = 0;

            for (int i = 0; i < rows; i++) {
                byte extremeValue = matrixC[i][0];

                for (int j = 1; j < cols; j++) {
                    if ((i + 1) % 2 == 1) {
                        // Непарний номер рядка — шукаємо максимум
                        if (matrixC[i][j] > extremeValue) {
                            extremeValue = matrixC[i][j];
                        }
                    } else {
                        // Парний номер рядка — шукаємо мінімум
                        if (matrixC[i][j] < extremeValue) {
                            extremeValue = matrixC[i][j];
                        }
                    }
                }

                sum += extremeValue;
            }

            // Виведення результатів
            System.out.println("Матриця C (A + B):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrixC[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Сума найбільших елементів у непарних рядках");
            System.out.println("та найменших елементів у парних рядках: " + sum);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення даних: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Помилка доступу до елементів масиву");
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        }
    }
}
