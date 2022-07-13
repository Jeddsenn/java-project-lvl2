package hexlet.code;

import java.util.*;
import static hexlet.code.ComparedData.generateListOfDifferences;
import static hexlet.code.Formatters.Formatter.generateJsonOutput;
import static hexlet.code.Parser.parseJsonToMap;

public class Differ {

    public static String generate(String format, String filepath1, String filepath2) throws Exception {
        Map<String, Object> firstMap = parseJsonToMap(String.valueOf(filepath1));
        Map<String, Object> secondMap = parseJsonToMap(String.valueOf(filepath2));
        List<Map<String, Object>> listOfDifference = generateListOfDifferences(firstMap,secondMap);

        String formattedOutput = "";
//        String formattedOutput = new Formatter(format);

        if (Objects.equals(format, "stylish")) {
            formattedOutput = generateJsonOutput(listOfDifference);
        }
        else if (Objects.equals(format, "plain")){
            formattedOutput = generateJsonOutput(listOfDifference);
        } else if (Objects.equals(format, "json")) {
            formattedOutput = generateJsonOutput(listOfDifference);

        }
        return formattedOutput;
    }
}