package hexlet.code;

import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Formatter {
    public static String stylishGenerate(Multimap<String, Map.Entry<String, Object>> answer) {
        String result = "{\n";
        for (Map.Entry<String, Map.Entry<String, Object>> ans: answer.entries()) {
            result = result.concat(ans.getKey() + ans.getValue().getKey() + ": " +  ans.getValue().getValue() + "\n");
        }
        result = result.concat("}");
        return result;
    }
    public static String plainGenerate(Multimap<String, Map.Entry<String, Object>> answer) {
        String result = "";
        Map<String, Integer> repeatingKeys = new LinkedHashMap<>();
        int count = 1;
        for (Map.Entry<String, Map.Entry<String, Object>> ans: answer.entries()) {
            if (repeatingKeys.containsKey(ans.getValue().getKey())) {
                int temp = count + 1;
                repeatingKeys.put(ans.getValue().getKey(), temp);
                continue;
            }
            repeatingKeys.put(ans.getValue().getKey(), count);
        }
        for (Map.Entry<String, Map.Entry<String, Object>> ans: answer.entries()) {
            Object temp = (ans.getValue().getValue().getClass() == LinkedHashMap.class
                    || ans.getValue().getValue().getClass() == ArrayList.class)
                    ? "[complex value]" : ans.getValue().getValue();
            if (ans.getKey().equals("    ")) {
                continue;
            }
            if (ans.getKey().equals("  - ") && repeatingKeys.get(ans.getValue().getKey()) == 1) {
                result = result.concat("Property '" + ans.getValue().getKey() + "' was removed\n");
            } else if (ans.getKey().equals("  + ") && repeatingKeys.get(ans.getValue().getKey()) == 1) {
                result = result.concat("Property '" + ans.getValue().getKey() + "' was added with value: "
                        + temp + "\n");
            } else {
                if (ans.getKey().equals("  - ")) {
                    result = result.concat("Property '" + ans.getValue().getKey() + "' was updated. From "
                            + temp + " to ");
                    continue;
                }
                result = result.concat(temp + "\n");
            }
        }
        return result;
    }
}
