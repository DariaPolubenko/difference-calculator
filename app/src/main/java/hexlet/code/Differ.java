package hexlet.code;

import static hexlet.code.Formatter.formatter;
import static hexlet.code.Tree.getTree;
import static hexlet.code.Content.formatContent;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1,  String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1,  String filepath2, String format) throws Exception {
        //filepath1 = filepath1.contains("src/test/resources/") ? filepath1 : "src/test/resources/" + filepath1;
        //filepath2 = filepath2.contains("src/test/resources/") ? filepath2 : "src/test/resources/" + filepath2;

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
        var result = formatContent(filepath, content);

        return result;
    }
}
