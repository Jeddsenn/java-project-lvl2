package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;


public class Parser {
    public static Map<String, Object> dataStructureToMap(String fileMap, String extension) throws Exception {
        new ObjectMapper();
        ObjectMapper objectMapper = switch (extension) {
            case "json" -> new ObjectMapper();
            case "yaml", "yml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new Exception(extension + " is not supported extension");
        };
        return objectMapper.readValue(fileMap, new TypeReference<>() {
        });
    }
}

