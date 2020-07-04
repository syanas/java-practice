package HW3_Generics;
import java.util.Map;

public class Program {
    static void printMap (CountMap o){
        Map innerMap = o.toMap();
        System.out.println(innerMap);
    }


    public static void main(String[] argv) {
        testCountMapClass();

    }
    static void testCountMapClass(){
        CountMap<Integer> map = new CountMapClass<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        //Test getCount(), add()
        /*int count = map.getCount(5); // 2
        System.out.println(count);
        count = map.getCount(6); // 1
        System.out.println(count);
        count = map.getCount(10); // 3
        System.out.println(count);*/

        //Test size()
        /*System.out.println(map.size()); //3*/

        //Test remove()
        /*map.remove(10);
        System.out.println(map.size()); //2*/

        CountMap<Integer> map2 = new CountMapClass<>();

        map2.add(10);
        map2.add(10);
        map2.add(5);

        //Test addAll()
        /*System.out.println("Map 1");
        printMap(map);
        System.out.println("Plus map 2");
        printMap(map2);
        System.out.println("Result");
        map.addAll(map2);
        printMap(map);*/

        CountMap<Integer> map3 = new CountMapClass<>();
        map3.add(6);
        map3.add(5);
        map3.add(10);

        //Test toMap()
        /*System.out.println("Map 3");
        printMap(map3);
        System.out.println("= map 1");
        printMap(map);
        System.out.println("Result in map 3");
        map.toMap((Map)map3);
        printMap(map3);*/
    }

}
