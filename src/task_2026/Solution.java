package task_2026;
/*
Задан массив a. Требуется каждый его элемент заменить на ближайший справа
больший. Результаты замен не влияют на другие, то есть считайте, что все
замены производятся одновременно. Если справа нет большего элемента, то
замените элемент на число 0.

Входные данные
В первой строке записано целое положительное число n (1 ≤ n ≤ 10000),
где n — длина заданного массива. Вторая строка содержит последовательность
a1, a2,..., an (1 ≤ ai ≤ 10000) — последовательность элементов заданного
массива.

Выходные данные
Выведите все элементы массива после замен. Числа разделяйте пробелами.

input.txt
6
5 3 8 2 3 4

output.txt
8 8 0 3 4 0
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);

        int array_size = scanner.nextInt();
        int[] array = new int[array_size];
        for (int i = 0; i < array_size; ++i) {
            array[i] = scanner.nextInt();
        }
        int[] newArray = new int[array_size];

        int maxIndexToTheRight = array_size - 1;
        newArray[maxIndexToTheRight] = 0;
        for (int i = array_size - 2; i >= 0; --i) {
            if (array[i] >= array[maxIndexToTheRight]) {
                maxIndexToTheRight = i;
                newArray[maxIndexToTheRight] = 0;
            } else {
                for (int j = i + 1; j <= maxIndexToTheRight; ++j) {
                    if (array[j] > array[i]) {
                        newArray[i] = array[j];
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < array_size; ++i) {
            System.out.format("%d ", newArray[i]);
        }
    }
}