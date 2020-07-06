package HW8_Lambda_StreamAPI;

/*
Реализовать класс похожий на java.util.stream.Stream
(http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html)
*/

import java.util.*;
import java.util.function.*;

public class Streams<T> {
    enum StreamType{
        filtration,
        transformation
    }

    private class FunctionInfo{
        StreamType streamType;
        Function func;
    }

    Iterator<T> dataIterator;
    ArrayList< FunctionInfo > functionQuery;

    private Streams (Collection<T> collection){
        dataIterator = collection.iterator();
        functionQuery = new ArrayList<>();
    }

    /*
    Streams.of() - статический метод, который принимает
    коллекцию и создает новый объект Streams
    */
    public static<T> Streams of(Collection<T> collection) {
        return new Streams<>(collection);
    }

    /*
    filter() - оставляет в коллекции только те элементы,
    которые удовлетворяют условию в лямбде.
    */
    public Streams filter(Predicate<T> predicate) {
        FunctionInfo functionInfo = new FunctionInfo();
        functionInfo.streamType = StreamType.filtration;
        functionInfo.func = (elem) -> predicate.test((T) elem);
        functionQuery.add(functionInfo);
        return this;
    }

    /*
    transform() - преобразует элемент в другой.
    */
    public Streams transform(Function<T, T> func) {
        FunctionInfo functionInfo = new FunctionInfo();
        functionInfo.streamType = StreamType.transformation;
        functionInfo.func = (elem) -> func.apply((T) elem);
        functionQuery.add(functionInfo);
        return this;
    }

    /*
    toMap - принимает 2 лямбды для создания мапы,
    в одной указывается, что использовать в качестве ключа,
    в другой, что в качестве значения.
    */
    public<K, V> Map toMap(Function<T, K> keyGetter, Function<T, V> valueGetter) {

        HashMap<K,V> result = new HashMap<>();

        for (Iterator<T> it = dataIterator; it.hasNext(); ) {
            T previousResult = it.next();
            Object currentResult;
            boolean doNotContinue = false;
            for (FunctionInfo fi: functionQuery){
                currentResult = fi.func.apply(previousResult);
                if (fi.streamType == StreamType.filtration){
                    if (!((Boolean) currentResult)){
                        doNotContinue = true;
                        break;
                    } else
                        continue;
                }
                previousResult = (T) currentResult;
            }

            if (! doNotContinue ) {
                result.put(keyGetter.apply(previousResult), valueGetter.apply(previousResult));
            }
        }

        return result;
    }
}
