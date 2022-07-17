package hexlet.code;

import hexlet.code.Formatters.Formatter;

import java.util.List;
import java.util.Map;

import static hexlet.code.ComparedData.generateListOfDifferences;
import static hexlet.code.Parser.parseJsonToMap;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> firstMap = parseJsonToMap(String.valueOf(filePath1));
        Map<String, Object> secondMap = parseJsonToMap(String.valueOf(filePath2));
        List<Map<String, Object>> listOfDifference = generateListOfDifferences(firstMap, secondMap);
        return Formatter.format(format, listOfDifference);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
