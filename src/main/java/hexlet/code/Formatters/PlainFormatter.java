package hexlet.code.Formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String generatePlainOutput(List<Map<String, Object>> listOfDifferences) {
        StringBuilder result = new StringBuilder("");
        for (Map<String, Object> l : listOfDifferences) {
            var status = l.get("status");
            var v = modifyOutputOfComplexObject(addStringSymbol(l.get("value")));
            var v1 = modifyOutputOfComplexObject(addStringSymbol(l.get("value1")));
            var v2 = modifyOutputOfComplexObject(addStringSymbol(l.get("value2")));
            var k = l.get("key");

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
                        .append(v1)
                        .append(" to ")
                        .append(v2)
                        .append("\n");
            }
        }
        result.trimToSize();
        return result.toString();
    }

    private static Object modifyOutputOfComplexObject(Object v) {
        if (v instanceof Collection || v instanceof Map<?, ?>) {
            return (String) "[complex value]";
        }
        return v;
    }
    static Object addStringSymbol(Object v) {
        if (v instanceof String) {
            return "\'" + v + "\'";
        }
        return v;
    }
}
