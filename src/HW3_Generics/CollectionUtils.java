package HW3_Generics;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static<T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static<T> List limit(List<? extends T> source, int size) {
        if (size < source.size())
            return source;
        else
            return source.subList(0,size);
    }

    public static<T> void add(List<Object> source, Object o) {
        source.add(o);
    }

    public static<T> void removeAll(List<? extends T> removeFrom, List<Object> c2) {
        for ( Object elem: c2) {
            removeFrom.remove(elem);
        }
    }

    //true если первый лист содержит все элементы второго
    public static<T> boolean containsAll(List<? extends T> c1, List<Object> c2) {
        boolean result = true;
        for ( Object elem: c2) {
            result &= c1.contains(elem);
        }
        return result;
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static<T> boolean containsAny(List<? extends T> c1, List c2) {
        boolean result = false;
        for ( Object elem: c2) {
            result |= c1.contains(elem);
        }
        return result;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static<T> List range(List<? extends T> list, Object min, Object max) {
        for(T o: list){
            Comparable<T> oComp = (Comparable<T>)o;
        }
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static List range(List list, Object min, Object max, Comparator comparator) {
    }

}
