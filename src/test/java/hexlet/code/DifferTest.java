package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @Test
    void testGenerateStylishJson() throws Exception {
        String format = "stylish";
        String path1 = String.valueOf(getFixturePath("file1.json"));
        String path2 = String.valueOf(getFixturePath("file2.json"));
        String result = readFixture("result_stylish.txt");
        String output = Differ.generate(path1, path2, format);
        assertEquals(result, output);
    }

    @Test
    void testGeneratePlainJson() throws Exception {
        String format = "plain";
        String path1 = String.valueOf(getFixturePath("file1.json"));
        String path2 = String.valueOf(getFixturePath("file2.json"));
        String result = readFixture("result_plain.txt");
        String output = Differ.generate(path1, path2, format);
        assertEquals(result, output);
    }

    @Test
    void testGenerateJsonlikeJson() throws Exception {
        String format = "json";
        String path1 = String.valueOf(getFixturePath("file1.json"));
        String path2 = String.valueOf(getFixturePath("file2.json"));
        String result = readFixture("result_json.json");
        String output = Differ.generate(path1, path2, format);
        assertEquals(result, output);
    }

    @Test
    void testGenerateStylishYaml() throws Exception {
        String format = "stylish";
        String path1 = String.valueOf(getFixturePath("file1.yaml"));
        String path2 = String.valueOf(getFixturePath("file2.yaml"));
        String result = readFixture("result_stylish.txt");
        String output = Differ.generate(path1, path2, format);
        assertEquals(result, output);
    }

    @Test
    void testGeneratePlainYaml() throws Exception {
        String format = "plain";
        String path1 = String.valueOf(getFixturePath("file1.yaml"));
        String path2 = String.valueOf(getFixturePath("file2.yaml"));
        String result = readFixture("result_plain.txt");
        String output = Differ.generate(path1, path2, format);
        assertEquals(result, output);
    }

    @Test
    void testGenerateNestedYamllikeJson() throws Exception {
        String format = "json";
        String path1 = String.valueOf(getFixturePath("file1.yaml"));
        String path2 = String.valueOf(getFixturePath("file2.yaml"));
        String result = readFixture("result_json.json");
        String output = Differ.generate(path1, path2, format);
        assertEquals(result, output);
    }
}
