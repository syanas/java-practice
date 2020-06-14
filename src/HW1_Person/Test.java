package HW1_Person;

import java.util.Scanner;

public class Test {
    public static void PersonInfo(Person person) {
        System.out.format("%s is a man: %b\n", person.name, person.man);
        String spouseName = (person.spouse != null) ? person.spouse.name : "None";
        System.out.format("Spouse: %s\n", spouseName);
    }

    public static void main(String[] argv) {
        Person Marry = new Person(false, "Marry");
        Person Bill = new Person(true, "Bill");
        Person Andy = new Person(true, "Andy");
        Person Jane = new Person(false, "Jane");

        PersonInfo(Marry);
        PersonInfo(Bill);
        PersonInfo(Andy);
        PersonInfo(Jane);

        //1
        //need to be true
        boolean marriageIsPossible = Marry.marry(Bill);
        System.out.format("For %s and %s marriage is possible: %b\n", Marry.name, Bill.name, marriageIsPossible);

        //2
        //need to be false
        marriageIsPossible = Andy.marry(Bill);
        System.out.format("For %s and %s marriage is possible: %b\n", Andy.name, Bill.name, marriageIsPossible);

        //3
        //need to be false
        marriageIsPossible = Jane.marry(Marry);
        System.out.format("For %s and %s marriage is possible: %b\n", Jane.name, Marry.name, marriageIsPossible);

        //4
        //need to be true
        marriageIsPossible = Jane.marry(Andy);
        System.out.format("For %s and %s marriage is possible: %b\n", Jane.name, Andy.name, marriageIsPossible);

        //5
        //need to be true
        boolean statusChanged = Jane.divorce();
        System.out.format("%s was married: %b\n", Jane.name, statusChanged);

        //5
        //need to be true
        marriageIsPossible = Jane.marry(Bill);
        System.out.format("For %s and %s marriage is possible: %b\n", Jane.name, Bill.name, marriageIsPossible);
    }
}
