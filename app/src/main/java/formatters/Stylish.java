package formatters;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Stylish {
    public static String formatter(List<Map<String, Object>> data) {
        var result = new StringBuilder();
        result.append("{\n");

        for (var map : data) {
            var oldValue = map.get("old value");
            var newValue = map.get("new value");

            if (Objects.equals(map.get("type"), "unupdated")) {
                result.append("    " + map.get("key") + ": " + oldValue + "\n");
            } else if (Objects.equals(map.get("type"), "updated")) {
                result.append("  - " + map.get("key") + ": " + oldValue + "\n");
                result.append("  + " + map.get("key") + ": " + newValue + "\n");
            } else if (Objects.equals(map.get("type"), "added")) {
                result.append("  + " + map.get("key") + ": " + newValue + "\n");
            } else if (Objects.equals(map.get("type"), "removed")) {
                result.append("  - " + map.get("key") + ": " + oldValue + "\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
