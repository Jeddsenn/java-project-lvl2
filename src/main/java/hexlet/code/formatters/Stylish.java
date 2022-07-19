package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    private static final String STATUS = "status";
    private static final String DELETED = "deleted";
    private static final String ADDED = "added";
    private static final String SAME = "same";
    private static final String CHANGED = "changed";
    private static final String KEY = "key";
    private static final String VALUE = "value";
    private static final String VALUE1 = "value1";
    private static final String VALUE2 = "value2";
    private static final String MINUS = "  - ";
    private static final String PLUS  = "  + ";
    private static final String SPACE = "    ";
    private static final String COLON = ": ";

    public static String render(List<Map<String, Object>> listOfDifferences) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> l : listOfDifferences) {
            var status = l.get(STATUS);
            if (status.equals(DELETED)) {
                result.append("  - ").append(l.get(KEY)).append(COLON).append(l.get(VALUE)).append("\n");
            }
            if (status.equals(ADDED)) {
                result.append(PLUS).append(l.get(KEY)).append(COLON).append(l.get(VALUE)).append("\n");
            } else if (status.equals(SAME)) {
                result.append(SPACE).append(l.get(KEY)).append(COLON).append(l.get(VALUE)).append("\n");
            } else if (status.equals(CHANGED)) {
                result.append(MINUS).append(l.get(KEY)).append(COLON).append(l.get(VALUE1)).append("\n");
                result.append(PLUS).append(l.get(KEY)).append(COLON).append(l.get(VALUE2)).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}


