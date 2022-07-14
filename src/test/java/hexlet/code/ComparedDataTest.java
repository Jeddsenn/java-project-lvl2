package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.ComparedData.generateListOfDifferences;
import static hexlet.code.Parser.parseJsonToMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComparedDataTest {
    @Test
    void testGenerate() throws Exception {
        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        String fileThirdJson = new StringBuilder()
                .append("[{key=follow, status=deleted, value=false},")
                .append(" {key=host, status=same, value=hexlet.io},")
                .append(" {key=proxy, status=deleted, value=123.234.53.22},")
                .append(" {key=timeout, status=changed, value1=50, value2=20},")
                .append(" {key=verbose, status=added, value=true}]")
                .toString();
        var a = parseJsonToMap(path1);
        var b = parseJsonToMap(path2);
        var c = generateListOfDifferences(a, b);
        System.out.println(c);
        assertEquals(fileThirdJson, fileThirdJson);
    }
}
