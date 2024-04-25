package hexlet.code;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Parser {
    public static Map<String, Object> parseJson(String content) throws Exception {
        if (content.isEmpty()) {
            return Map.of("", "");
        }
        ObjectMapper parseContent = new ObjectMapper();
        return parseContent.readValue(content, Map.class);
    }

    public static Map<String, Object> parseYaml(String content) throws Exception {
        if (content.isEmpty()) {
            return Map.of("", "");
        }
        ObjectMapper parseContent = new YAMLMapper();
        return parseContent.readValue(content, Map.class);
    }
}
