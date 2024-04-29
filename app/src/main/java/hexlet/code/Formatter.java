package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Formatter {
    public static String stylish(List<Map<String, Object>> data) {
        var result = new StringBuilder();
        result.append("{\n");

        for (var map : data) {
            map.forEach((key, value) -> {
                var oldValue = map.get("old value");
                var newValue = map.get("new value");
                if (key.equals("")) {
                    result.append("");
                } else if (Objects.equals(map.get(key), "unchanged")) {
                    result.append("    " + map.get("key") + ": " + oldValue + "\n");
                } else if (Objects.equals(map.get(key), "changed")) {
                    result.append("  - " + map.get("key") + ": " + oldValue + "\n");
                    result.append("  + " + map.get("key") + ": " + newValue + "\n");
                } else if (Objects.equals(map.get(key), "added")) {
                    result.append("  + " + map.get("key") + ": " + newValue + "\n");
                } else if (Objects.equals(map.get(key), "deleted")) {
                    result.append("  - " + map.get("key") + ": " + oldValue + "\n");
                }
            });
        }
        result.append("}");
        return result.toString();
    }
}
