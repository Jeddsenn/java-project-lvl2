package hexlet.code.Formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {

    public static String generateStylishOutput(List<Map<String, Object>> listOfDifferences) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> l : listOfDifferences) {
            var status = l.get("status");
            if (status.equals("deleted")) {
                result.append("  - ").append(l.get("key")).append(": ").append(l.get("value")).append("\n");
            }
            if (status.equals("added")) {
                result.append("  + ").append(l.get("key")).append(": ").append(l.get("value")).append("\n");
            } else if (status.equals("same")) {
                result.append("    ").append(l.get("key")).append(": ").append(l.get("value")).append("\n");
            } else if (status.equals("changed")) {
                result.append("  - ").append(l.get("key")).append(": ").append(l.get("value1")).append("\n");
                result.append("  + ").append(l.get("key")).append(": ").append(l.get("value2")).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}


