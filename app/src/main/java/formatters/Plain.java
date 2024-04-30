package formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Plain {
    public static String formatter(List<Map<String, Object>> data) {
        var result = new StringBuilder();

        for (var map : data) {
            var oldValue = map.get("old value") instanceof ArrayList<?>
                    || map.get("old value") instanceof Map<?, ?> ? "[complex value]"
                    : map.get("old value") instanceof String ? "'" + map.get("old value") + "'"
                    : map.get("old value");

            var newValue = map.get("new value") instanceof ArrayList<?>
                    || map.get("new value") instanceof Map<?, ?> ? "[complex value]"
                    : map.get("new value") instanceof String ? "'" + map.get("new value")  + "'"
                    : map.get("new value");

            if (Objects.equals(map.get("type"), "unupdated")) {
                result.append("");
            } else if (Objects.equals(map.get("type"), "updated")) {
                result.append("Property " + "'" + map.get("key") + "'"
                        + " was updated. From " + oldValue + " to " + newValue + "\n");
            } else if (Objects.equals(map.get("type"), "added")) {
                result.append("Property " + "'" + map.get("key") + "'"
                        + " was added with value: " + newValue + "\n");
            } else if (Objects.equals(map.get("type"), "removed")) {
                result.append("Property " + "'" + map.get("key") + "'" + " was removed" + "\n");
            }
        }
        return result.toString();
    }
}
