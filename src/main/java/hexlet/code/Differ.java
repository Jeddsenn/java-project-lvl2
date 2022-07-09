package hexlet.code;

import hexlet.code.ComparedData.KeyDifference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        List<KeyDifference> result = new ArrayList<>();

        for (String key : firstMap.keySet()) {
            KeyDifference tmp = new KeyDifference();
            tmp.setKeyValue(key);
            tmp.setInFirstJson(true);
            tmp.setFirstValue(String.valueOf(firstMap.get(key)));
            if (secondMap.containsKey(key)) {
                tmp.setInSecondJson(true);
                tmp.setSecondValue(String.valueOf(secondMap.get(key)));
            }
            result.add(tmp);
        }

        for (String key : secondMap.keySet()) {
            if (!firstMap.containsKey(key)) {
                KeyDifference tempObj = new KeyDifference();
                tempObj.setKeyValue(key);
                tempObj.setInSecondJson(true);
                tempObj.setSecondValue(String.valueOf(secondMap.get(key)));
                result.add(tempObj);
            }
        }

        result.sort(Comparator.comparing(KeyDifference::getKeyValue));

        StringBuilder resultString = new StringBuilder("{\n  ");
        for (KeyDifference diff : result) {
            resultString.append(diff.formatter());
        }

        resultString.deleteCharAt(resultString.length() - 1);
        resultString.deleteCharAt(resultString.length() - 1);
        resultString.append("}");
        return resultString.toString();
    }
}
