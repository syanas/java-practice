package task_2036;
/*
Дан набор из n слов, состоящих из маленьких латинских букв. Будем называть
слово странным, если в нем встречаются 3 или более гласные буквы подряд.
Ваша задача — удалить из данного набора все странные слова.

Гласными буквами в латинском алфавите считаются e,y,u,i,o,a.

Входные данные
В первой строке содержится число n — количество слов в наборе, n не
превосходит 100. Далее в n строках по одному на строке содержатся слова из
набора. Слова состоят только из маленьких латинских букв. Длина каждого
слова не менее 1 и не более 20 символов.

Выходные данные
Выведите все слова из набора, не являющиеся странными. Каждое слово выводите
на отдельной строке в том порядке, в котором они заданы во входных данных.
*/

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solution {
    private static final String REGEX = "[eyuioa]{3,}";
    private static final Pattern p = Pattern.compile(REGEX);

    private static boolean isStrange(String a_input) {
        Matcher m = p.matcher(a_input);
        return m.find();
    }

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);

        int stringNumber = Integer.parseInt(scanner.nextLine());
        String[] inputStrings = new String[stringNumber];
        for (int i = 0; i < stringNumber; ++i) {
            inputStrings[i] = scanner.nextLine();
        }

        for (int i = 0; i < stringNumber; ++i) {
            if (!isStrange(inputStrings[i]))
                System.out.println(inputStrings[i]);
        }
    }
}
