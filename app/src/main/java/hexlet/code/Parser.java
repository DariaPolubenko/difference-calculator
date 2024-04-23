package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map parseJson(String content) throws Exception {

        if (content.isEmpty()) {
             return Map.of("", "");
        }

        ObjectMapper parseContent = new ObjectMapper();
        return parseContent.readValue(content, Map.class);
    }
}
