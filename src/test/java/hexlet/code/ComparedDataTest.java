package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.ComparedData.generateListOfDifferences;
import static hexlet.code.Parser.parseJsonToMap;
import static org.junit.jupiter.api.Assertions.*;

class ComparedDataTest {
    @Test
    void testReGenerate() throws Exception {
        String format = "stylish";
        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        String path3 = "src/test/resources/file12.json";
        String fileThirdJson = "[{key=follow, value=false, status=deleted}," +
                " {key=host, oldvalue=hexlet.io," +
                " newvalue=hexlet.io, status=same}," +
                " {key=proxy, value=123.234.53.22, status=deleted}," +
                " {key=timeout, oldvalue=50, newvalue=20, status=changed}," +
                " {key=verbose, value=true, status=added}]\n";
        var a = parseJsonToMap(path1);
        var b = parseJsonToMap(path2);
        var c = generateListOfDifferences(a,b);
        System.out.println(c);
        assertEquals(fileThirdJson, c);
    }
}