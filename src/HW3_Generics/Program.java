package HW3_Generics;
import java.util.*;

class MyComparator implements Comparator<Integer> {

    public int compare(Integer a, Integer b){

        return a.compareTo(b);
    }
}
public class Program {
    static void printMap (CountMap o){
        Map innerMap = o.toMap();
        System.out.println(innerMap);
    }


    public static void main(String[] argv) {
        //testCountMapClass();
        testCollectionUtils();
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
        map.toMap(map3.toMap());
        printMap(map3);*/
    }

    static void testCollectionUtils(){
        List<Number> myArr = CollectionUtils.newArrayList();
        myArr.add(1);
        myArr.add(2);
        myArr.add(3);

        List<Integer> myArr2 = CollectionUtils.newArrayList();
        myArr2.add(11);
        myArr2.add(12);
        myArr2.add(13);

        CollectionUtils.addAll(myArr2, myArr);
        //System.out.println(myArr.toString());

        //System.out.println(CollectionUtils.indexOf(myArr,11));

        //System.out.println(CollectionUtils.limit(myArr,3).toString());

        //CollectionUtils.removeAll(myArr,myArr2);
        //System.out.println(myArr.toString());

        //System.out.println(CollectionUtils.containsAny(myArr,myArr2));
        //System.out.println(CollectionUtils.containsAll(myArr2,myArr));

        //System.out.println(CollectionUtils.range(Arrays.asList(8,1,3,5,6, 4), 3, 6));
        //System.out.println(CollectionUtils.range(Arrays.asList(8,1,3,5,6, 4), 3, 6, new MyComparator()));
    }
}
