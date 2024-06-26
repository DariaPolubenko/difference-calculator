package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Stylish {
    public static String formatter(List<Map<String, Object>> data) {
        var result = new StringBuilder();
        result.append("{\n");

        for (var map : data) {
            var value = stringify(map.get("value"));
            var value1 = stringify(map.get("value1"));
            var value2 = stringify(map.get("value2"));

            if (Objects.equals(map.get("type"), "unupdated")) {
                result.append("    " + map.get("key") + ": " + value + "\n");
            } else if (Objects.equals(map.get("type"), "updated")) {
                result.append("  - " + map.get("key") + ": " + value1 + "\n");
                result.append("  + " + map.get("key") + ": " + value2 + "\n");
            } else if (Objects.equals(map.get("type"), "added")) {
                result.append("  + " + map.get("key") + ": " + value + "\n");
            } else if (Objects.equals(map.get("type"), "removed")) {
                result.append("  - " + map.get("key") + ": " + value + "\n");
            }
        }
        result.append("}");
        return result.toString();
    }

    public static String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        return value + "";
    }
}
