package task_2057;
/*
Ваша задача — реализовать структуру данных, которая умеет хранить
мультимножество натуральных чисел, т.е. в этой структуре могут одновременно
храниться несколько равных элементов.

Эта структура должна поддерживать две операции:
1) добавить элемент x в множество;
2) удалить минимальный элемент в множестве и вернуть его значение (если
   минимальных элементов несколько, то удаляется только один из них).

Входные данные
Первая строка входных данных содержит число n (1 ≤ n ≤ 106) — количество
операций. Далее в n строках даны описания операций над множеством.
Описание представляет собой число — тип запроса (1 или 2) и
число x (1 ≤ x ≤ 109) если это запрос первого типа.

Выходные данные
Для каждого запроса второго типа выведите результат на отдельной строке.

input.txt
6
1 3
1 2
1 1
2
2
2

output.txt
1
2
3
*/

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Solution {

    public static class MultiSet<E> {
        private PriorityQueue<E> data;

        public MultiSet() {
            data = new PriorityQueue<>();
        }

        public void addElement(E element) {
            data.add(element);
        }

        public Object removeOneMinElement() {
            return data.poll();
        }
    }

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        MultiSet<Integer> multiset = new MultiSet<>();

        ArrayList<Object> deletedMins = new ArrayList<>();
        int actionsCount = scanner.nextInt();
        for (int i = 0; i < actionsCount; ++i) {
            int actionType = scanner.nextInt();
            switch (actionType) {
                case 1:
                    multiset.addElement(scanner.nextInt());
                    break;
                case 2:
                    deletedMins.add(multiset.removeOneMinElement());
                    break;
            }
        }

        for (Object element : deletedMins) {
            System.out.println(element);
        }
    }
}
