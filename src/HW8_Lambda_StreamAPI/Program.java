package HW8_Lambda_StreamAPI;

import java.util.*;
import java.util.function.Function;

public class Program {
    static class Person{
        String name;
        String surname;
        Integer age;

        public Person(String aName, String aSurname, Integer aAge) {
            name = aName;
            surname = aSurname;
            age = aAge;
        }

        public Integer getAge(){
            return age;
        }

        public String getName(){
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] argv){

        List<Person> someCollection = new ArrayList<>();
        someCollection.add(new Person("Alice", "Black", 20));
        someCollection.add(new Person("Ann", "Gold", 25));
        someCollection.add(new Person("Fred", "Berg", 15));
        someCollection.add(new Person("Elizabeth", "Wolf", 5));
        someCollection.add(new Person("Mike", "Norman", 65));

        for (Person person: someCollection) {
            System.out.println(person);
        }

        Map m1 = Streams.of(someCollection)
                .filter(p -> ((Person)p).getAge() > 20)
                .toMap(p -> ((Person)p).getName(), p -> p);
        System.out.println(m1);

        Map m2 = Streams.of(someCollection)
                .filter(p -> ((Person)p).getAge() > 20)
                .transform(p -> new Person(
                        ((Person)p).getName(),
                        ((Person)p).getName(),
                        ((Person)p).getAge() + 30)
                )
                .toMap(p -> ((Person)p).getName(), p -> p);

        System.out.println(m2);
    }

}
