package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {

    private static final String STATUS = "status";
    private static final String DELETED = "deleted";
    private static final String ADDED = "added";
    private static final String CHANGED = "changed";
    private static final String KEY = "key";
    private static final String VALUE = "value";
    private static final String VALUE1 = "value1";
    private static final String VALUE2 = "value2";
    private static final String PROPERTY = "Property ";
    public static String render(List<Map<String, Object>> listOfDifferences) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> l : listOfDifferences) {
            var status = l.get(STATUS);
            var value = modifyOutputOfComplexObject(addStringSymbol(l.get(VALUE)));
            var value1 = modifyOutputOfComplexObject(addStringSymbol(l.get(VALUE1)));
            var value2 = modifyOutputOfComplexObject(addStringSymbol(l.get(VALUE2)));
            var key = addStringSymbol(l.get(KEY));

            if (status.equals(DELETED)) {                      //removed
                result.append(PROPERTY)
                        .append(key)
                        .append(" was removed")
                        .append("\n");
            }
            if (status.equals(ADDED)) {                                      //added
                result.append(PROPERTY)
                        .append(key)
                        .append(" was added with value: ")
                        .append(value)
                        .append("\n");
            } else if (status.equals(CHANGED)) {                     //updated
                result.append(PROPERTY)
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

    private static Object modifyOutputOfComplexObject(Object v) {
        if (v instanceof Collection || v instanceof Map<?, ?>) {
            return "[complex value]";
        }
        return v;
    }
    static Object addStringSymbol(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }
}
