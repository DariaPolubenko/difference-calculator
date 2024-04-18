package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class Differ {
   public static String generate(Map data1, Map data2) {

       Map result = new HashMap<>(data1);

       //var keysOfData1 = data1.keySet();
       //var result = new StringBuilder();

       var keys = data2.keySet();
       for (var key : keys) {
           result.compute(key, (key, count) -> {
               count == null ? 1 : count + 1);

               }
           }

       }








       return str;


    }
}
