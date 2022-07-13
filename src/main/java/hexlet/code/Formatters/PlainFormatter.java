package hexlet.code.Formatters;

import java.util.*;

public class PlainFormatter {
    public static String generatePlainOutput(List<Map<String, Object>> listOfDifferences) {
        StringBuilder result = new StringBuilder("");
        for (Map<String, Object> l : listOfDifferences) {
            var status = l.get("status");
            var v = l.get("value");
            var v1 = l.get("value1");
            var v2 = l.get("value2");
            var k = l.get("key");
            if (v instanceof List<?> || v instanceof Map<?,?>) {
                v = "[complex value]";
            }
            if (v1 instanceof List<?> || v1 instanceof Map<?,?>) {
                v1 = "[complex value]";
            }
            if (v2 instanceof List<?> || v2 instanceof Map<?,?>) {
                v2 = "[complex value]";
            }

            if (status.equals("deleted")) {                      //removed
                    result.append("Property ")
                            .append("'")
                            .append(k)
                            .append("'")
                            .append(" was removed")
                            .append("\n");
            }
          if (status.equals("added")) {                                      //added
                result.append("Property ")
                        .append("'")
                        .append(k)
                        .append("'")
                        .append(" was added with value: ")
                        .append(v)
                        .append("\n");
            }
          if (status.equals("same")) {
             result.append("");
           } else if (status.equals("changed")) {                     //updated
                result.append("Property ")
                        .append("'")
                        .append(k)
                        .append("'")
                        .append(" was updated. From ")
                        .append("'")
                        .append(v1)
                        .append("'")
                        .append(" to ")
                        .append("'")
                        .append(v2)
                        .append("'")
                        .append("\n");
            }
        }
        result.trimToSize();
        return result.toString();
    }
}
