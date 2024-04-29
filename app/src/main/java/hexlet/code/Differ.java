package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        var sortedData1 = new TreeMap<>(data1);
        var unitedData = new TreeMap<>(data2);

        sortedData1.forEach((key, value) -> {
            unitedData.computeIfAbsent(key, (v) -> value);
        });
        var result = new StringBuilder();
        result.append("{\n");

        unitedData.forEach((key, value) -> {
            var value1 = data1.get(key); //метод, который переформатирует значение в строку
            var value2 = data1.get(key);

            if (key.equals("")) {
                result.append("");
            } else if (data1.containsKey(key) && data2.containsKey(key)) {
                if (Objects.equals(data1.get(key), data2.get(key))) {
                    result.append("    " + key + ": " + value + "\n");
                } else {
                    result.append("  - " + key + ": " + data1.get(key) + "\n");
                    result.append("  + " + key + ": " + data2.get(key) + "\n");
                }
            } else if (!data1.containsKey(key)) {
                result.append("  + " + key + ": " + data2.get(key) + "\n");
            } else if (!data2.containsKey(key)) {
                result.append("  - " + key + ": " + data1.get(key) + "\n");
            }
        });
        result.append("}");
        return result.toString();
    }

   // @Override
    //public String toString(Object value) {

}
