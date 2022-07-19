package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static String render(List<Map<String, Object>> listOfDifferences) throws JsonProcessingException {
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
