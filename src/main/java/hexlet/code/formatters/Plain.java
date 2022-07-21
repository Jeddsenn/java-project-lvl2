package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String render(List<Map<String, Object>> listOfDifferences) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> l : listOfDifferences) {
            var status = l.get("status");
            var value = stringify(l.get("value"));
            var value1 = stringify(l.get("value1"));
            var value2 = stringify(l.get("value2"));
            var key = addStringSymbol(l.get("key"));
            if (status.equals("deleted")) {                      //removed
                result.append("Property ")
                        .append(key)
                        .append(" was removed")
                        .append("\n");
            }
            if (status.equals("added")) {                                      //added
                result.append("Property ")
                        .append(key)
                        .append(" was added with value: ")
                        .append(value)
                        .append("\n");
            } else if (status.equals("changed")) {                     //updated
                result.append("Property ")
                        .append(key)
                        .append(" was updated. From ")
                        .append(value1)
                        .append(" to ")
                        .append(value2)
                        .append("\n");
            }
        }
        String r = result.toString();
        return r.trim();
    }

    private static Object stringify(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Collection || value instanceof Map<?, ?>) {
            value = "[complex value]";
        }
        return value;
    }

    static Object addStringSymbol(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }
}
