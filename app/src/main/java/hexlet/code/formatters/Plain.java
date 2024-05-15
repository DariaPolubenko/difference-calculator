package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Plain {
    public static String formatter(List<Map<String, Object>> data) {

        var result = new StringBuilder();

        for (var map : data) {
            var value = map.get("value") instanceof ArrayList<?>
                    || map.get("value") instanceof Map<?, ?> ? "[complex value]"
                    : map.get("value") instanceof String ? "'" + map.get("value") + "'"
                    : map.get("value");

            var value1 = map.get("value1") instanceof ArrayList<?>
                    || map.get("value1") instanceof Map<?, ?> ? "[complex value]"
                    : map.get("value1") instanceof String ? "'" + map.get("value1") + "'"
                    : map.get("value1");

            var value2 = map.get("value2") instanceof ArrayList<?>
                    || map.get("value2") instanceof Map<?, ?> ? "[complex value]"
                    : map.get("value2") instanceof String ? "'" + map.get("value2")  + "'"
                    : map.get("value2");

            if (Objects.equals(map.get("type"), "unupdated")) {
                result.append("");
            } else if (Objects.equals(map.get("type"), "updated")) {
                result.append("Property " + "'" + map.get("key") + "'"
                        + " was updated. From " + value1 + " to " + value2 + "\n");
            } else if (Objects.equals(map.get("type"), "added")) {
                result.append("Property " + "'" + map.get("key") + "'"
                        + " was added with value: " + value + "\n");
            } else if (Objects.equals(map.get("type"), "removed")) {
                result.append("Property " + "'" + map.get("key") + "'" + " was removed" + "\n");
            }
        }
        var interimResult = result.toString();
        return interimResult.substring(0, interimResult.length() - 1);
    }
}
