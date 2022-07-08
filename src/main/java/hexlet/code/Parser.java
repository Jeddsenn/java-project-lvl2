package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parseJsonToMap(String filepath1) throws Exception {
        ObjectMapper objectMapper;
        if (getFileExtension(filepath1) == ".json") {
            objectMapper = new ObjectMapper();
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        String fileFirstJson = generatePathToFile(String.valueOf(filepath1));
        return objectMapper.readValue(fileFirstJson, new TypeReference<>() {
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

