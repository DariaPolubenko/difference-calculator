package hexlet.code;

import static hexlet.code.Formatter.formatter;
import static hexlet.code.Tree.getTree;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1,  String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1,  String filepath2, String format) throws Exception {
        filepath1 = filepath1.contains("/") ? filepath1 : "src/test/resources/" + filepath1;
        filepath2 = filepath2.contains("/") ? filepath2 : "src/test/resources/" + filepath2;

        var data1 = getData(filepath1);
        var data2 = getData(filepath2);

        List<Map<String, Object>> differences = getTree(data1, data2);
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
}
