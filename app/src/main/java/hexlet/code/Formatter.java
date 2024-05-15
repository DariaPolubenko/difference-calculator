package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatter(List<Map<String, Object>> differences, String format) throws Exception {

        switch (format) {
            case "stylish":
                return Stylish.formatter(differences);
            case "plain":
                return Plain.formatter(differences);
            case "json":
                return Json.formatter(differences);
            default:
                System.out.println("Don't have format \"" + format + "\"");
        }
        return null;
    }
}
