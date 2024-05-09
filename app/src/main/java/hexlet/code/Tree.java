package hexlet.code;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tree {
    public static List<Map<String, Object>> getTree(Map<String, Object> data1, Map<String, Object> data2) {
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
                    helperMap.put("value1", value1);
                    helperMap.put("value2", value1);

                    result.add(helperMap);
                } else {
                    helperMap.put("key", key);
                    helperMap.put("type", "updated");
                    helperMap.put("value1", value1);
                    helperMap.put("value2", value2);

                    result.add(helperMap);
                }
            } else if (!data1.containsKey(key)) {
                helperMap.put("key", key);
                helperMap.put("type", "added");
                helperMap.put("value1", "");
                helperMap.put("value2", value2);

                result.add(helperMap);

            } else if (!data2.containsKey(key)) {
                helperMap.put("key", key);
                helperMap.put("type", "removed");
                helperMap.put("value1", value1);
                helperMap.put("value2", "");

                result.add(helperMap);
            }
        });
        return result;
    }
}
