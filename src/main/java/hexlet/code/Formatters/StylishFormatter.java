package hexlet.code.Formatters;

import hexlet.code.ComparedData;

import java.util.List;
import java.util.Map;

public class StylishFormatter {

    public static String generateStylishOutput(List<Map<String, Object>> listOfDifferences) {
        String result = "";
/*
        StringBuilder resultString = new StringBuilder("{\n  ");
        for (ComparedData.KeyDifference diff : result) {
            resultString.append(formatter(diff));
        }
        resultString.deleteCharAt(resultString.length() - 1);
        resultString.deleteCharAt(resultString.length() - 1);
        resultString.append("}");
        return resultString.toString();
    }
    public static String toStylishFormat(String result) {
        String r = "";

*/

        return result;
    }
}


/*
Property 'chars2' was updated. From [complex value] to false
        Property 'checked' was updated. From false to true
        Property 'default' was updated. From null to [complex value]
        Property 'id' was updated. From 45 to null
        Property 'key1' was removed
        Property 'key2' was added with value: 'value2'
        Property 'numbers2' was updated. From [complex value] to [complex value]
        Property 'numbers3' was removed
        Property 'numbers4' was added with value: [complex value]
        Property 'obj1' was added with value: [complex value]
        Property 'setting1' was updated. From 'Some value' to 'Another value'
        Property 'setting2' was updated. From 200 to 300
        Property 'setting3' was updated. From true to 'none'
*/
