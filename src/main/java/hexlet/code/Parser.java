package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;


public class Parser {
    public static Map<String, Object> dataStructureToMap(String fileMap) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();  //
        String filePath = Differ.generatePathToFile(fileMap);
        if (Differ.getFileExtension(fileMap).equals("json")) {
            objectMapper = new ObjectMapper();
        }
        if (Differ.getFileExtension(fileMap).equals("yaml") || Differ.getFileExtension(fileMap).equals("yml")) {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        return objectMapper.readValue(filePath, new TypeReference<>() {
        });
    }
    public static Map<String, Object> dataStructureToMap(String fileMap, String extension) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        if (extension.equals("json")) {
            objectMapper = new ObjectMapper();
        }
        if (extension.equals("yaml") || extension.equals("yml")) {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        return objectMapper.readValue(fileMap, new TypeReference<>() {
        });
    }
}

