package HW3_Generics;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static<T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static<T> List limit(List<? extends T> source, int size) {
        if (size >= source.size())
            return source;
        else
            return source.subList(0, size);
    }

    public static<T> void add(List<Object> source, Object o) {
        source.add(o);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for ( T elem: c2) {
            removeFrom.remove(elem);
        }
    }

    //true если первый лист содержит все элементы второго
    public static<T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        boolean result = true;
        for ( T elem: c2) {
            result &= c1.contains(elem);
        }
        return result;
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static<T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        boolean result = false;
        for ( T elem: c2) {
            result |= c1.contains(elem);
        }
        return result;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static<T> List range(List<? extends T> list, Object min, Object max) {
        List result = CollectionUtils.newArrayList();
        for(T o: list){
            Comparable oComp = (Comparable<T>)o;
            if (oComp.compareTo(min) >= 0 &&  oComp.compareTo(max) <= 0){
                CollectionUtils.add(result, o);
            }
        }
        return result;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static<T> List range(List<? extends T> list, T min, T max, Comparator comparator) {
        List result = CollectionUtils.newArrayList();
        for(T o: list){
            if (comparator.compare(o,min) >= 0 &&  comparator.compare(o,max)<= 0){
                CollectionUtils.add(result, o);
            }
        }
        return result;
    }

}
