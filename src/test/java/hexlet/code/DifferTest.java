package hexlet.code;

import org.junit.jupiter.api.Test;
import static hexlet.code.Differ.generate;
import static hexlet.code.Parser.generatePathToFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testGenerate() throws Exception {
        String format = "stylish";
        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        String path3 = "src/test/resources/file12.json";
        String fileThirdJson = generatePathToFile(path3);
        String output = generate(format, path1, path2);
        assertEquals(fileThirdJson, output);
    }

    @Test
    void testGenerateYaml() throws Exception {
        String format = "stylish";
        String path1 = "src/test/resources/file1.yaml";
        String path2 = "src/test/resources/file2.yaml";
        String path3 = "src/test/resources/file12.json";
        String fileThirdJson = generatePathToFile(path3);

        String output = generate(format, path1, path2);
        assertEquals(fileThirdJson, output);
    }

    @Test
    void testGenerateNestedJson() throws Exception {
        String format = "stylish";
        String path1 = "src/test/resources/file31.json";
        String path2 = "src/test/resources/file32.json";
        String path3 = "src/test/resources/file34.json";
        String fileThirdJson = generatePathToFile(path3);

        String output = generate(format, path1, path2);
        assertEquals(fileThirdJson, output);
    }

    @Test
    void testGenerateNestedYaml() throws Exception {
        String format = "stylish";
        String path1 = "src/test/resources/file41.yaml";
        String path2 = "src/test/resources/file42.yaml";
        String path3 = "src/test/resources/file34.json";
        String fileThirdJson = generatePathToFile(path3);

        String output = generate(format, path1, path2);
        assertEquals(fileThirdJson, output);
    }
}