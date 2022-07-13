package hexlet.code;

import hexlet.code.Formatters.Formatter;

import java.util.List;
import java.util.Map;

import static hexlet.code.ComparedData.generateListOfDifferences;
import static hexlet.code.Parser.parseJsonToMap;

public class Differ {

    public static String generate(String format, String filepath1, String filepath2) throws Exception {
        Map<String, Object> firstMap = parseJsonToMap(String.valueOf(filepath1));
        Map<String, Object> secondMap = parseJsonToMap(String.valueOf(filepath2));
        List<Map<String, Object>> listOfDifference = generateListOfDifferences(firstMap, secondMap);
        return Formatter.format(format, listOfDifference);
    }
}
