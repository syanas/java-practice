package HW2_Collections;
/*
Исходные данные: текстовый файл со средней длиной строки равной 10 символам
(файл или прошить текст в коде).

В реализациях используйте наиболее подходящие имплементации коллекций!

Задание 1: Подсчитайте количество различных слов в файле.
Задание 2: Выведите на экран список различных слов файла, отсортированный по
    возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово
    встречается в файле.
Задание 4: Выведите на экран все строки файла в обратном порядке.
Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
Задание 6: Выведите на экран строки, номера которых задаются пользователем в
    произвольном порядке.
*/

import java.util.*;
import java.io.*;
import java.util.HashMap;

public class Solution {
    private static class LengthStringComparator implements Comparator<String> {
        public int compare(String firstStr, String secondStr) {
            Integer lengthCompare = Integer.compare(firstStr.length(),secondStr.length());
            Integer orderCompare = firstStr.compareTo(secondStr);
            return (lengthCompare == 0)? orderCompare :lengthCompare;
        }
    }
    private static class DecreasingLinkedListIterator3 implements Iterator<LinkedList<String>> {
        //private String current = LinkedList<String>.last;
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public LinkedList<String> next() {
            return null;
        }
    }
    public static void task1(LinkedList<String> text, HashSet<String> distinctWords){
        for (String line: text) {
            for (String word : line.split("\\W+")) {
                distinctWords.add(word);
            }
        }
    }

    public static void task2(LinkedList<String> text, TreeSet<String> sortedDistinctWords){
        for (String line: text) {
            for (String word : line.split("\\W+")) {
                sortedDistinctWords.add(word);
            }
        }
    }

    public static void task3(LinkedList<String> text, HashMap<String, Integer> wordCounter){
        for (String line: text) {
            for (String word : line.split("\\W+")) {
                if (wordCounter.containsKey(word)) {
                    wordCounter.replace(word, wordCounter.get(word) + 1);
                } else {
                    wordCounter.put(word, 1);
                }
            }
        }
    }

    public static void task4(LinkedList<String> text){
        Iterator<String> iterator = text.descendingIterator();
        for (Iterator<String> it = iterator; it.hasNext(); ) {
            String line = it.next();
            System.out.println(line);
        }
    }

    public static void task5(Iterator<LinkedList> iterText){

    }

    public static void main(String[] argv) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        LinkedList<String> text = new LinkedList<>();
        text.add("I have a pair of gloves!");
        text.add("London is a capital of Great Britain.");
        text.add("My name is Java.");

        HashSet<String> distinctWords = new HashSet<>();
//        task1(text, distinctWords);

        TreeSet<String> sortedDistinctWords = new TreeSet<> (new LengthStringComparator());
//        task2(text,  sortedDistinctWords);
//        for(String word:sortedDistinctWords){
//            System.out.println(word);
//        }

        HashMap<String, Integer> wordCounter = new HashMap<>();
//        task3(text, wordCounter);

//        task4(text);


    }
}
