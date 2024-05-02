package hexlet.code;

import static hexlet.code.Formatter.formatter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Objects;

public class Differ {
    public static String generate(String filepath1,  String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1,  String filepath2, String format) throws Exception {
        filepath1 = filepath1.contains("/") ? filepath1 : "src/test/resources/" + filepath1;
        filepath2 = filepath2.contains("/") ? filepath2 : "src/test/resources/" + filepath2;

        var data1 = getData(filepath1);
        var data2 = getData(filepath2);

        List<Map<String, Object>> differences = getDifference(data1, data2);
        return formatter(differences, format);
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        var fullPath = Paths.get(filepath).toAbsolutePath().normalize();

        if (!Files.exists(fullPath)) {
            throw new Exception("File '" + fullPath + "' does not exist");
        }
        var content = Files.readString(fullPath);

        String[] format = filepath.split("\\.");
        switch (format[1]) {
            case "json":
                return Parser.parseJson(content);
            case "yml":
                return Parser.parseYaml(content);
            default:
                System.out.println("Don't have this format: \"" + format[1] + "\"");
        }
        return null;
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
