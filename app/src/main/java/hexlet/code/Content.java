package hexlet.code;

import java.util.Map;

public class Content {
    public static Map<String, Object> formatContent(String filepath, String content) throws Exception {
        if (filepath.lastIndexOf("json") > 0) {
            return Parser.parseJson(content);
        } else if (filepath.lastIndexOf("yml") > 0) {
            return Parser.parseYaml(content);
        } else {
            System.out.println("Don't have this format");
        }
        return null;
    }
}
