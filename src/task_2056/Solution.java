package task_2056;
/*
Дан текст, ваша задача — найти слово, которое встречается в тексте наибольшее
количество раз. Текст состоит только из латинских букв, пробелов, переводов
строк.

Слово — это последовательность подряд идущих латинских букв, регистр не имеет
значения.

Если искомых слов несколько, ваша задача — найти все такие слова.

Входные данные
Входные данные состоят только из латинских букв, пробелов и символов перевода
строки. Гарантируется, что хотя бы одно слово в текст присутствует.

Выходные данные
Выведите все слова, которые встречаются наибольшее количество раз, при их
следут приводить к нижнему регистру, каждое слово выводите на отдельной строке.
Слова выводите в лексикографическом порядке. Размер входного файла не
превосходит 100 Кб.

input.txt
Sebastian Vettel is a German Formula One racing driver currently driving for
Red Bull Racing

output.txt
racing
*/

import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> wordCount = new HashMap<>();

        while (scanner.hasNext()) {
            String inputLine = scanner.next().toLowerCase();
            if (wordCount.containsKey(inputLine)) {
                Integer oldValue = wordCount.get(inputLine);
                wordCount.replace(inputLine, oldValue + 1);
            } else {
                wordCount.put(inputLine, 1);
            }
        }

        Integer maxValue = Collections.max(wordCount.values());
        TreeSet<String> mostFrequentWords = new TreeSet<>();
        wordCount.forEach(
                (str, val) -> {
                    if (val.equals(maxValue))
                        mostFrequentWords.add(str);
                }
        );

        for (String mostFrequentWord : mostFrequentWords) {
            System.out.println(mostFrequentWord);
        }
    }
}
