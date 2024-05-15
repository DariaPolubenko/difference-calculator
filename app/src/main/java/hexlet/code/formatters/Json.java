package formatters;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Json {
    public static String formatter(List<Map<String, Object>> data) throws Exception {
        var result = new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(data);
        return result;
    }
}
