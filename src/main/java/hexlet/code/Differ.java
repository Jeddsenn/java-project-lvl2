package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> firstMap1 = getData(String.valueOf(filePath1));
        Map<String, Object> secondMap2 = getData(String.valueOf(filePath2));
        List<Map<String, Object>> listOfDifference = Tree.build(firstMap1, secondMap2);
        return Formatter.format(format, listOfDifference);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
    public static Map<String, Object> getData(String filePath) throws Exception {
        String path = generatePathToFile(filePath);
        String extension = getFileExtension(filePath);
        return Parser.dataStructureToMap(path, extension);
    }

    public static String getFileExtension(String fileName) {
        int lastDot = fileName.lastIndexOf('.');
        return fileName.substring(lastDot + 1);
    }

    public static String generatePathToFile(String fileName) throws IOException {
        return Files.readString(Paths.get(fileName).toAbsolutePath().normalize());
    }
}
