package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import static hexlet.code.Differ.genPath;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {




    @Test
    void testGenerate() throws IOException {
/*
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);
*/


        String path1 = "file1.json";
        String path2 = "file2.json";
        String path3 = "file12.json";
        String fileFirstJson = genPath(path1);
        String fileSecondJson = genPath(path2);
        String fileThirdJson = genPath(path3);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapFirst = mapper.readValue(fileFirstJson, new TypeReference<>() {
        });
        Map<String, Object> mapSecond = mapper.readValue(fileSecondJson, new TypeReference<>() {
        });
        var diff = new Differ().generate(mapFirst, mapSecond);

        assertEquals(fileThirdJson, diff);
    }


}