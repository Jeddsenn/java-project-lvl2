package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(String format, List<Map<String, Object>> listOfDifferences) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.render(listOfDifferences);
            case "json" -> Json.render(listOfDifferences);
            case "plain" -> Plain.render(listOfDifferences);
            default -> throw new Exception(format + " is not supported");
        };
    }
}
