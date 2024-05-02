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
            var value1 = getNewValue(map.get("value1"));
            var value2 = getNewValue(map.get("value2"));

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

    public static Object getNewValue(Object value) {
        if (value instanceof ArrayList<?>) {
            var result = new StringBuilder();
            result.append("[ ");

            ((ArrayList<?>) value).forEach((valueOfList) -> {
                if (valueOfList instanceof String) {
                    result.append("\"" + valueOfList + "\", ");
                } else if (valueOfList instanceof Integer) {
                    result.append(valueOfList + ", ");
                }
            });
            var interimResult = result.toString();
            var fullResult = interimResult.substring(0, interimResult.length() - 2);
            return fullResult + " ]";

        } else if (value instanceof String) {
            return "\"" + value + "\"";

        } else if (value instanceof Map<?, ?>) {
            var result = new StringBuilder();
            result.append("{\n");

            ((Map<?, ?>) value).forEach((key, valueOfMap) -> {
                result.append("    " + "\"" + key + "\"" + " : ");
                if (valueOfMap instanceof String) {
                    result.append("\"" + valueOfMap + "\",\n");
                } else {
                    result.append(valueOfMap + ",\n");
                }
            });
            var interimResult = result.toString();
            var fullResult = interimResult.substring(0, interimResult.length() - 2);
            return fullResult + "\n  }";
        }
        return value;
    }

}
