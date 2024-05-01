package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatter(List<Map<String, Object>> differences, String format) throws Exception {

        var result = format.equals("stylish") ? Stylish.formatter(differences)
                : format.equals("plain") ? Plain.formatter(differences)
                : format.equals("json") ? Json.formatter(differences)
                : "Don't have format " + format;

        return result;
    }
}
