package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Set;
import java.util.Objects;

public class Tree {

    public static List<Map<String, Object>> build(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Set<String> keySet = new TreeSet<>(firstMap.keySet());
        keySet.addAll(secondMap.keySet());
        for (String key : keySet) {
            Map<String, Object> map = new TreeMap<>();
            if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                map.put("status", "deleted");
                map.put("key", key);
                map.put("value", firstMap.get(key));   // -
            } else if (secondMap.containsKey(key) && !firstMap.containsKey(key)) {
                map.put("status", "added");
                map.put("key", key);
                map.put("value", secondMap.get(key));  // +
            } else if (Objects.equals(firstMap.get(key), (secondMap.get(key)))) {
                map.put("status", "same"); // тут без символов
                map.put("key", key);
                map.put("value", firstMap.get(key));
            } else {
                map.put("status", "changed");
                map.put("key", key);
                map.put("value1", firstMap.get(key));   //  -
                map.put("value2", secondMap.get(key));  // +
            }
            resultList.add(map);
        }
        return resultList;
    }
}
