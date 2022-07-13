package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static hexlet.code.Differ.generate;
import static hexlet.code.Parser.generatePathToFile;
import static hexlet.code.Parser.getFileExtension;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void getFileExtensionTest() {
        String path1 = "src/test/resources/file1.yaml";
        String fileThirdJson = getFileExtension(path1);
        assertEquals("yaml", fileThirdJson);
    }
    void getFileExtensionTest1() {
        String path1 = "src/test/resources/file1.json";
        String fileThirdJson = getFileExtension(path1);
        assertEquals("json", fileThirdJson);
    }
}