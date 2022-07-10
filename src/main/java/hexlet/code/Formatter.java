package hexlet.code;

import java.util.List;

public class Formatter {
    public static String generateStylishOutput(List<ComparedData.KeyDifference> result) {
        StringBuilder resultString = new StringBuilder("{\n  ");
        for (ComparedData.KeyDifference diff : result) {
            resultString.append(diff.formatter());
        }
        resultString.deleteCharAt(resultString.length() - 1);
        resultString.deleteCharAt(resultString.length() - 1);
        resultString.append("}");
        return resultString.toString();
    }
}
