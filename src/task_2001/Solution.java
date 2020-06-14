package task_2001;
/*
Заданы a и b. Выведите a+b.

Входные данные
В единственной строке входных данных заданы целочисленные a и b (1 ≤ a,b ≤ 1000).

Выходные данные
Выведите a+b.
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(a + b);
    }
}
