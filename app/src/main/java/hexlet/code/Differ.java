package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Objects;

import static hexlet.code.Formatter.formatter;

public class Differ {

    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        return generate(data1, data2, "stylish");
    }

    public static String generate(Map<String, Object> data1, Map<String, Object> data2, String format) {
        List<Map<String, Object>> differences = getDifference(data1, data2);

        return formatter(differences, format);
    }

    public static List<Map<String, Object>> getDifference(Map<String, Object> data1, Map<String, Object> data2) {
        var unitedKeys = new TreeMap<>(data2);
        data1.forEach((key, value) -> {
            unitedKeys.computeIfAbsent(key, (v) -> value);
        });
        var result = new ArrayList<Map<String, Object>>();

        unitedKeys.forEach((key, value) -> {
            var helperMap = new HashMap<String, Object>();
            var value1 = data1.get(key);
            var value2 = data2.get(key);

            if (key.equals("")) {
                result.add(Map.of("", ""));

            } else if (data1.containsKey(key) && data2.containsKey(key)) {
                if (Objects.equals(value1, value2)) {
                    helperMap.put("key", key);
                    helperMap.put("type", "unupdated");
                    helperMap.put("old value", value1);
                    helperMap.put("new value", value1);

                    result.add(helperMap);
                } else {
                    helperMap.put("key", key);
                    helperMap.put("type", "updated");
                    helperMap.put("old value", value1);
                    helperMap.put("new value", value2);

                    result.add(helperMap);
                }
            } else if (!data1.containsKey(key)) {
                helperMap.put("key", key);
                helperMap.put("type", "added");
                helperMap.put("old value", "");
                helperMap.put("new value", value2);

                result.add(helperMap);

            } else if (!data2.containsKey(key)) {
                helperMap.put("key", key);
                helperMap.put("type", "removed");
                helperMap.put("old value", value1);
                helperMap.put("new value", "");

                result.add(helperMap);
            }
        });
        return result;
    }
}
