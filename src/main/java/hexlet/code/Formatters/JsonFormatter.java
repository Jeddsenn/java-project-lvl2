package hexlet.code.Formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonFormatter {
    public static String generateJsonOutput(List<Map<String, Object>> listOfDifference) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            String result = objectMapper.writeValueAsString(listOfDifference);
            // мож тут потом цикл пиздануть по каждой мапе по отельности для красоты вывода?
            result = toJsonFormat(result);
            return result;
        }

    private static String toJsonFormat(String result) {
            return result.replace(":", ": ")
                    .replace(",", ", \n")
                    .replace("[{", "[  \n{")
                    .replace("}, {", "\n },\n{")
                    .replace("}]", "\n}\n]");
        }
}
