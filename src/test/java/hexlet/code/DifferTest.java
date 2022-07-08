package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;
import static hexlet.code.Parser.generatePathToFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testGenerate() throws IOException {
        String path1 = "file1.json";
        String path2 = "file2.json";
        String path3 = "file12.json";
        String fileThirdJson = generatePathToFile(path3);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapFirst = mapper.readValue(generatePathToFile(path1), new TypeReference<>() {
        });
        Map<String, Object> mapSecond = mapper.readValue(generatePathToFile(path2), new TypeReference<>() {
        });
        assertEquals(fileThirdJson, new Differ().generate(mapFirst, mapSecond));
    }
}