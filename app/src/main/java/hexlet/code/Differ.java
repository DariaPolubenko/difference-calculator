package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;



public class Differ {
    public static Map generate(Map data1, Map data2) {

        //Map result = new HashMap<>();
        var result = new StringBuilder();

        // знаю, что цикл в цикле - решение merda, и решение выглядит супер сложно,
        // но пока не понимаю, как решить оптимальнее, не в лоб
        // возможно, тут могут сработать функции/стримы, но х(

        for (var key1 : data1.keySet()) {

            for (var key2 : data2.keySet()) {

                if (key1.equals(key2)) {
                    var value1 = data1.get(key1);
                    var value2 = data2.get(key2);

                    if (value1.equals(value2)) {
                        result.append("<li>");
                        result.put("  " + key1, value1);
                    } else {
                        result.put("- " + key1, value1);
                        result.put("+ " + key1, value2);
                    }
                } else if (!data2.containsKey(key1)) {
                    result.put("- " + key1, data1.get(key1));
                } else if (!data1.containsKey(key2)) {
                    result.put("+ " + key2, data1.get(key2));
                }
            }
        }
        var sortedMap = new TreeMap<>(result);

        //var sortedResult = result.entrySet().stream()
                //.sorted()

        return sortedMap;
    }
}

