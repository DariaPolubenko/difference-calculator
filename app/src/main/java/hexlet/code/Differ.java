package hexlet.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;



public class Differ {
    public static String generate(Map data1, Map data2) {

        var firstSorted = new TreeMap<>(data1);
        var unitedMap = new TreeMap<>(data2);
        firstSorted.forEach((key, value) -> {
            if (!unitedMap.containsKey(key)) {
                unitedMap.put(key, value);
            }
        });

        var result = new StringBuilder();
        result.append("{\n");
        unitedMap.forEach((key, value) -> {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    result.append("   " + key + ": " + value + "\n");
                } else {
                    result.append(" - " + key + ": " + data1.get(key) + "\n");
                    result.append(" + " + key + ": " + data2.get(key) + "\n");
                }
            } else if (!data1.containsKey(key)) {
                result.append(" + " + key + ": " + data2.get(key) + "\n");
            }else if (!data2.containsKey(key)) {
                result.append(" - " + key + ": " + data1.get(key) + "\n");
            }
        });
        result.append("}");
        return result.toString();
    }
}

