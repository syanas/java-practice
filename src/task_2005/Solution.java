package task_2005;
/*
Заданы n целых чисел. Выведите индекс (позицию) первого из минимальных
элементов последовательности. Элементы последовательности занумерованы
от 1 слева направо.

Входные данные
В первой строке записано целое число n (1 ≤ n ≤ 10000). Вторая строка
содержит последовательность целых чисел a1, a2,..., an
(-10000 ≤ ai ≤ 10000).

Выходные данные
Выведите искомый индекс.
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int minIndex = 1;
        int lastMinNumber = scanner.nextInt();
        for (int i = 2; i <= n; ++i) {
            int currentNumber = scanner.nextInt();
            if (currentNumber < lastMinNumber) {
                minIndex = i;
                lastMinNumber = currentNumber;
            }
        }

        System.out.println(minIndex);
    }
}