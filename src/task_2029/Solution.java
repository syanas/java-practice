package task_2029;
/*
Задан массив из n чисел (a1, a2,..., an).Ваша задача — найти позицию среднего
элемента среди минимальных в массиве.Обратите внимание, что если минимальных
чисел в массиве четное количество, то средних элементов два. В этом случае
нужно вывести минимальную позицию среди средних элементов.

Входные данные
В первой строке входного файла дано число n (1 ≤ n ≤ 100) — количество чисел
в массиве. Во второй строке через пробел записаны целые числа
a1, a2,..., an (1 ≤ ai ≤ 100).

Выходные данные
Выведите единственное число — позицию среднего элемента среди минимальных в
массиве.

input.txt
5
1 1 2 1 1

output.txt
2
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> minIndices = new ArrayList<>();
        int minCount = 0;
        int minIndexLeft = 0;

        int array_size = scanner.nextInt();
        int[] array = new int[array_size];
        for (int i = 0; i < array_size; ++i) {
            int currentElement = scanner.nextInt();
            array[i] = currentElement;
            if (array[minIndexLeft] == currentElement) {
                minIndices.add(i);
                ++minCount;
            }
            if (array[minIndexLeft] > currentElement) {
                minIndexLeft = i;
                minIndices.clear();
                minIndices.add(i);
                minCount = 1;
            }
        }

        int targetMinNumber = (minCount - 1) / 2;

        System.out.println(minIndices.get(targetMinNumber) + 1);
    }
}
