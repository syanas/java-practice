package HW3_Generics;

import HW3_Generics.CountMap;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class CountMapClass<E> implements CountMap<E> {
    HashMap<E,Integer> innerData = new HashMap<>();

    @Override
    public void add(Object o) {
        if (innerData.containsKey(o)){
            Integer lastValue = innerData.get(o);
            innerData.replace((E) o, lastValue + 1);
        } else
            innerData.put((E) o, 1);
    }

    @Override
    public int getCount(Object o) {
        int count = 0;
        if (innerData.containsKey(o)){
            count = innerData.get((E) o);
        }
        return count;
    }

    @Override
    public int remove(Object o) {
        int count = this.getCount(o);
        if (count != 0)
            innerData.remove(o);
        return count;
    }

    @Override
    public int size() {
        return innerData.size();
    }

    @Override
    public void addAll(CountMap<E> source) {
        Map<E, Integer> sourceMap = source.toMap();
        Set<Map.Entry<E, Integer>> entries = sourceMap.entrySet();
        for (Map.Entry<E, Integer> elem: entries) {
            E keyElem = elem.getKey();
            Integer keyValue = elem.getValue();
            if (innerData.containsKey(keyElem)){
                Integer lastValue = innerData.get(keyElem);
                innerData.replace(keyElem, lastValue + keyValue);
            } else
                innerData.put(keyElem, keyValue);
        }
    }

    @Override
    public Map toMap() {
        return (Map<E, Integer>)innerData;
    }

    @Override
    public void toMap(Map destination) {
        destination.putAll(this.toMap());
    }
}
