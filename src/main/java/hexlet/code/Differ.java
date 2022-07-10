package hexlet.code;

import hexlet.code.ComparedData.KeyDifference;

import java.util.*;

import static hexlet.code.Parser.parseJsonToMap;

public class Differ {

    public static String generate(String format, String filepath1, String filepath2) throws Exception {
        var firstMap = parseJsonToMap(String.valueOf(filepath1));
        var secondMap = parseJsonToMap(String.valueOf(filepath2));
        var listOfDifference = generateList(firstMap,secondMap);
        var formattedOutput = "";
        if (Objects.equals(format, "stylish")) {
            formattedOutput = generateStylishOutput(listOfDifference);
        }


        return formattedOutput;
    }

    public static List<KeyDifference> generateList(Map<String, Object> firstMap, Map<String, Object> secondMap) {
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
        return result;
    }

    public static String generateStylishOutput(List<KeyDifference> result) {
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
