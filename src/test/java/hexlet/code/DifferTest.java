package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import static hexlet.code.Parser.generatePathToFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testGenerate() throws IOException {
        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        String path3 = "src/test/resources/file12.json";
        String fileThirdJson = generatePathToFile(path3);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> mapFirst = mapper.readValue(generatePathToFile(path1), new TypeReference<>() {
        });
        Map<String, Object> mapSecond = mapper.readValue(generatePathToFile(path2), new TypeReference<>() {
        });
        assertEquals(fileThirdJson, new Differ().generate(mapFirst, mapSecond));
    }

    @Test
    void testGenerateYaml() throws IOException {
        String path1 = "src/test/resources/file1.yaml";
        String path2 = "src/test/resources/file2.yaml";
        String path3 = "src/test/resources/file12.json";
        String fileThirdJson = generatePathToFile(path3);


        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> mapFirst = mapper.readValue(generatePathToFile(path1), new TypeReference<>() {
        });
        Map<String, Object> mapSecond = mapper.readValue(generatePathToFile(path2), new TypeReference<>() {
        });
        assertEquals(fileThirdJson, new Differ().generate(mapFirst, mapSecond));
    }

    @Test
    void testGenerateNestedJson() throws IOException {
        String path1 = "src/test/resources/file31.json";
        String path2 = "src/test/resources/file32.json";
        String path3 = "src/test/resources/file34.json";
        String fileThirdJson = generatePathToFile(path3);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> mapFirst = mapper.readValue(generatePathToFile(path1), new TypeReference<>() {
        });
        Map<String, Object> mapSecond = mapper.readValue(generatePathToFile(path2), new TypeReference<>() {
        });
        assertEquals(fileThirdJson, new Differ().generate(mapFirst, mapSecond));
    }

    @Test
    void testGenerateNestedYaml() throws IOException {
        String path1 = "src/test/resources/file41.yaml";
        String path2 = "src/test/resources/file42.yaml";
        String path3 = "src/test/resources/file34.json";
        String fileThirdJson = generatePathToFile(path3);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> mapFirst = mapper.readValue(generatePathToFile(path1), new TypeReference<>() {
        });
        Map<String, Object> mapSecond = mapper.readValue(generatePathToFile(path2), new TypeReference<>() {
        });
        assertEquals(fileThirdJson, new Differ().generate(mapFirst, mapSecond));
    }
}