package hexlet.code;

import org.junit.jupiter.api.Test;
import static hexlet.code.Differ.generate;
import static hexlet.code.Parser.generatePathToFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testGenerateStylishJson() throws Exception {
        String format = "stylish";
        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        String path3 = "src/test/resources/file12.json";
        String fileThirdJson = generatePathToFile(path3);
        String output = generate(path1, path2, "stylish");
        assertEquals(fileThirdJson, output);
    }

    @Test
    void testGenerateStylishYaml() throws Exception {
        String format = "stylish";
        String path1 = "src/test/resources/file1.yaml";
        String path2 = "src/test/resources/file2.yaml";
        String path3 = "src/test/resources/file12.json";
        String fileThirdJson = generatePathToFile(path3);
        String output = generate(path1, path2, "stylish");
        assertEquals(fileThirdJson, output);
    }

    @Test
    void testGenerateNestedStylishJson() throws Exception {
        String format = "stylish";
        String path1 = "src/test/resources/file31.json";
        String path2 = "src/test/resources/file32.json";
        String path3 = "src/test/resources/file34.json";
        String fileThirdJson = generatePathToFile(path3);

        String output = generate(path1, path2, "stylish");
        assertEquals(fileThirdJson, output);
    }
    @Test
    void testGenerateNestedPlainJson() throws Exception {
        String format = "plain";
        String path1 = "src/test/resources/file41.yaml";
        String path2 = "src/test/resources/file42.yaml";
        String path3 = "src/test/resources/file34Plain.json";
        String fileThirdJson = generatePathToFile(path3);
        String output = generate(path1, path2, "plain");
        assertEquals(fileThirdJson, output);
    }
    @Test
    void testGenerateJsonlikeJson() throws Exception {
        String format = "json";
        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        String path3 = "src/test/resources/file12Jsonn";
        String fileThirdJson = generatePathToFile(path3);
        String output = generate(path1, path2, "json");
        assertEquals(fileThirdJson, output);
    }
    @Test
    void testGenerateNestedStylishYaml() throws Exception {
        String format = "stylish";
        String path1 = "src/test/resources/file41.yaml";
        String path2 = "src/test/resources/file42.yaml";
        String path3 = "src/test/resources/file34.json";
        String fileThirdJson = generatePathToFile(path3);

        String output = generate(path1, path2, format);
        assertEquals(fileThirdJson, output);
    }
}
