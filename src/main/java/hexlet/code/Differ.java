package hexlet.code;

import hexlet.code.ComparedData.KeyDifference;

import java.util.*;

import static hexlet.code.Parser.parseJsonToMap;

public class Differ {

    public static String generate(String format, String filepath1, String filepath2) throws Exception {
        Map<String, Object> firstMap = parseJsonToMap(String.valueOf(filepath1));
        Map<String, Object> secondMap = parseJsonToMap(String.valueOf(filepath2));
        List<KeyDifference> listOfDifference = ComparedData.generateList(firstMap,secondMap);
        String formattedOutput = "";

        if (Objects.equals(format, "stylish")) {
            formattedOutput = Formatter.generateStylishOutput(listOfDifference);
        }
        return formattedOutput;
    }

}
