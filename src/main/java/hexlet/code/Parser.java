package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class Parser {
    public static Map<String, Object> parseJsonToMap(String filepath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = generatePathToFile(filepath);
        if (getFileExtension(filepath).equals("json")) {
            objectMapper = new ObjectMapper();
        } if (getFileExtension(filepath).equals("yaml")){
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        return objectMapper.readValue(filePath, new TypeReference<>() {
        });
    }
    public static String getFileExtension(String fileName) {
        int lastDot = fileName.lastIndexOf('.');
        return fileName.substring(lastDot + 1);
    }
    public static String generatePathToFile(String fileName) throws IOException {
        return Files.readString(Paths.get(fileName).toAbsolutePath().normalize());
    }
}

