package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Differ {
    private static class KeyDifference {
        String keyValue = "";
        String firstValue = "";
        String secondValue = "";
        boolean isInFirstJson = false;
        boolean isInSecondJson = false;

        @Override
        public String toString() {
            String result = "";
            if (isInFirstJson && isInSecondJson) {
                if (!firstValue.equals(secondValue)) {
                    result = result + "- " + keyValue + ": " + firstValue + "\n";
                    result = result + "+ " + keyValue + ": " + secondValue + "\n";
                } else {
                    result = result + "  " + keyValue + ": " + firstValue + "\n";
                }
            } else if (isInFirstJson) {
                result = result + "- " + keyValue + ": " + firstValue + "\n";
            } else if (isInSecondJson) {
                result = result + "+ " + keyValue + ": " + secondValue + "\n";
            }
            return result;
        }
    }
    public String generate(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        List<KeyDifference> result = new ArrayList<>();

        for (String key : firstMap.keySet()) {
            KeyDifference tmp = new KeyDifference();
            tmp.keyValue = key;
            tmp.isInFirstJson = true;
            tmp.firstValue = String.valueOf(firstMap.get(key));
            if (secondMap.containsKey(key)) {
                tmp.isInSecondJson = true;
                tmp.secondValue = String.valueOf(secondMap.get(key));
            }
            result.add(tmp);
        }

        for (String key : secondMap.keySet()) {
            if (!firstMap.containsKey(key)) {
                KeyDifference tempObj = new KeyDifference();
                tempObj.keyValue = key;
                tempObj.isInSecondJson = true;
                tempObj.secondValue = String.valueOf(secondMap.get(key));
                result.add(tempObj);
            }
        }

        result.sort(Comparator.comparing(a -> a.keyValue));
        StringBuilder resultString = new StringBuilder("{\n");
        for (KeyDifference diff : result) {
            resultString.append(diff.toString());
        }
        resultString.append("}");
        return resultString.toString();
    }

    public static String genPath(String filePath) throws IOException {

        String relativeanabspathPath = filePath;
        if (!filePath.startsWith("/home")) {
            relativeanabspathPath = "src/main/resources/" + filePath;
        }
        if (!Path.of(relativeanabspathPath).toFile().exists()) {
            relativeanabspathPath = "src/test/resources/" + filePath;
        }
        return Files.readString(Paths.get(relativeanabspathPath).toAbsolutePath().normalize());
    }
}
