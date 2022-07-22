package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;


public class Parser {
    public static Map<String, Object> dataStructureToMap(String data, String extension) throws Exception {
            switch (extension) {
                case "json" -> {
                    return parseJson(data);
                }
                case "yaml", "yml" -> {
                    return parseYaml(data);
                }
                default -> throw new Exception(extension + " is not supported extension");
        }
    }
    public static Map<String, Object> parseYaml(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(data, new TypeReference<>() {
        });
    }
    public static Map<String, Object> parseJson(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(data, new TypeReference<>() {
        });
    }
}

