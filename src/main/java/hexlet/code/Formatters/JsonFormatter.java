package hexlet.code.Formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonFormatter {
    public static String generateJsonOutput(List<Map<String, Object>> listOfDifferences) throws JsonProcessingException {
        StringBuilder sb = new StringBuilder("");
        ObjectMapper objectMapper = new ObjectMapper();
        for (Map<String, Object> list : listOfDifferences) {
            sb.append(objectMapper.writeValueAsString(list));
        }
        return toJsonFormat(sb.toString());
    }

    private static String toJsonFormat(String result) {
            return result.replace(":", ": ")
                    .replace(",", ", \n")
                    .replace("[{", "[  \n{")
                    .replace("}, {", "\n },\n{")
                    .replace("}]", "\n}\n]");
        }
}

