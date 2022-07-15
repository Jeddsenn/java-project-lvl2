package hexlet.code.Formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonFormatter {
    public static String generateJsonOutput(List<Map<String, Object>> listOfDifferences)
            throws JsonProcessingException {
        StringBuilder sb = new StringBuilder("");
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfDifferences);
        return toJsonFormat(result);
    }

    private static String toJsonFormat(String result) {
        return result.replace(" : ", ": ")
                .replace("[ {", "[\n  {")
                .replace("}, {", "  },\n  {")
                .replace("  \"", "    \"")
                .replace("} ]", "  }\n]");
    }
}
