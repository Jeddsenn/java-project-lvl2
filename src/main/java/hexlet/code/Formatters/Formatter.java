package hexlet.code.Formatters;

import java.util.List;
import java.util.Map;

import static hexlet.code.Formatters.JsonFormatter.generateJsonOutput;
import static hexlet.code.Formatters.PlainFormatter.generatePlainOutput;
import static hexlet.code.Formatters.StylishFormatter.generateStylishOutput;

public class Formatter {
    public static String format(String format, List<Map<String, Object>> listOfDifferences) throws Exception {
        return switch (format) {
            case "stylish" -> generateStylishOutput(listOfDifferences);
            case "json" -> generateJsonOutput(listOfDifferences);
            case "plain" -> generatePlainOutput(listOfDifferences);
            default -> throw new Exception(format + "is not supported");
        };
    }
}
