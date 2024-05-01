package formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Json {
    public static String formatter(List<Map<String, Object>> data) throws Exception {
        var result = new StringBuilder();
        result.append("[ ");

        for (var map : data) {
            var value1 = getValue(map.get("value1"));
            var value2 = getValue(map.get("value2"));

            if (Objects.equals(map.get("type"), "unupdated")) {
                result.append("{\n  \"type\" : \"unupdated\",\n");
                result.append("  \"value\" : " + value1 + ",\n");
                result.append("  \"key\" : \"" + map.get("key") + "\"\n");
                result.append("}, ");
            } else if (Objects.equals(map.get("type"), "updated")) {
                result.append("{\n  \"value2\" : " + value2 + ",\n");
                result.append("  \"value1\" : " + value1 + ",\n");
                result.append("  \"type\" : \"updated\",\n");
                result.append("  \"key\" : \"" + map.get("key") + "\"\n");
                result.append("}, ");

            } else if (Objects.equals(map.get("type"), "added")) {
                result.append("{\n  \"type\" : \"added\",\n");
                result.append("  \"value\" : " + value2 + ",\n");
                result.append("  \"key\" : \"" + map.get("key") + "\"\n");
                result.append("}, ");
            } else if (Objects.equals(map.get("type"), "removed")) {
                result.append("{\n  \"type\" : \"removed\",\n");
                result.append("  \"value\" : " + value1 + ",\n");
                result.append("  \"key\" : \"" + map.get("key") + "\"\n");
                result.append("}, ");
            }
        }
        var interimResult = result.toString();
        var fullResult = interimResult.substring(0, interimResult.length() - 2);
        return fullResult + " ]";
    }

    public static Object getValue(Object value) {

        if (value instanceof ArrayList<?>) {
            var result = new StringBuilder();
            result.append("[ ");

            ((ArrayList<?>) value).forEach((v) -> {
                if (v instanceof String) {
                    result.append("\"" + v + "\", ");
                } else if (v instanceof Integer) {
                    result.append(v + ", ");
                }
            });
            var interimResult = result.toString();
            var fullResult = interimResult.substring(0, interimResult.length() - 2);
            return fullResult + " ]";
        }

        if (value instanceof String) {
            return "\"" + value + "\"";
        }

        if (value instanceof Map<?, ?>) {
            var result = new StringBuilder();
            result.append("{\n");

            var entries = ((Map<?, ?>) value).entrySet();
            for (var entry : entries) {
                result.append("    " + "\"" + entry.getKey() + "\"" + " : ");
                value = entry.getValue();
                if (value instanceof String) {
                    result.append("\"" + value + "\",\n");
                } else {
                    result.append(value + ",\n");
                }
            }
            var interimResult = result.toString();
            var fullResult = interimResult.substring(0, interimResult.length() - 2);
            return fullResult + "\n  }";
        }
        return value;
    }

}
