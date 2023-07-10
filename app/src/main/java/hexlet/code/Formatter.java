package hexlet.code;

import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Formatter {
    public static Map<String, Integer> findRepeatingKeys(Multimap<String, Map.Entry<String, Object>> multimap) {
        Map<String, Integer> repeatingKeys = new LinkedHashMap<>();
        int count = 1;
        for (Map.Entry<String, Map.Entry<String, Object>> entriesOfMap: multimap.entries()) {
            if (repeatingKeys.containsKey(entriesOfMap.getValue().getKey())) {
                int temp = count + 1;
                repeatingKeys.put(entriesOfMap.getValue().getKey(), temp);
                continue;
            }
            repeatingKeys.put(entriesOfMap.getValue().getKey(), count);
        }
        return repeatingKeys;
    }
    public static String stylishGenerate(Multimap<String, Map.Entry<String, Object>> multimap) {
        String result = "{\n";
        for (Map.Entry<String, Map.Entry<String, Object>> entriesOfMap: multimap.entries()) {
            result = result.concat(entriesOfMap.getKey() + entriesOfMap.getValue().getKey()
                    + ": " +  entriesOfMap.getValue().getValue() + "\n");
        }
        result = result.concat("}");
        return result;
    }
    public static String plainGenerate(Multimap<String, Map.Entry<String, Object>> multimap) {
        String result = "";
        Map<String, Integer> repeatingKeys = findRepeatingKeys(multimap);
        for (Map.Entry<String, Map.Entry<String, Object>> entriesOfMap: multimap.entries()) {
            Object temp = (entriesOfMap.getValue().getValue().getClass() == LinkedHashMap.class
                    || entriesOfMap.getValue().getValue().getClass() == ArrayList.class)
                    ? "[complex value]" : entriesOfMap.getValue().getValue();
            if (entriesOfMap.getKey().equals("    ")) {
                continue;
            }
            if (entriesOfMap.getKey().equals("  - ") && repeatingKeys.get(entriesOfMap.getValue().getKey()) == 1) {
                result = result.concat("Property '" + entriesOfMap.getValue().getKey() + "' was removed\n");
            } else if (entriesOfMap.getKey().equals("  + ")
                    && repeatingKeys.get(entriesOfMap.getValue().getKey()) == 1) {
                result = result.concat("Property '" + entriesOfMap.getValue().getKey() + "' was added with value: "
                        + temp + "\n");
            } else {
                if (entriesOfMap.getKey().equals("  - ")) {
                    result = result.concat("Property '" + entriesOfMap.getValue().getKey() + "' was updated. From "
                            + temp + " to ");
                    continue;
                }
                result = result.concat(temp + "\n");
            }
        }
        return result;
    }
    public static String jsonGenerate(Multimap<String, Map.Entry<String, Object>> multimap) {
        String result = "{\n  Removed: {\n";
        Map<String, Integer> repeatingKeys = findRepeatingKeys(multimap);
        for (Map.Entry<String, Map.Entry<String, Object>> entriesOfMap: multimap.entries()) {
            if (entriesOfMap.getKey().equals("  - ") && repeatingKeys.get(entriesOfMap.getValue().getKey()) == 1) {
                result = result.concat("    " + entriesOfMap.getValue().getKey()
                        + ": " + entriesOfMap.getValue().getValue() + "\n");
            }
        }
        result = result.concat("  }\n  Added: {\n");
        for (Map.Entry<String, Map.Entry<String, Object>> entriesOfMap: multimap.entries()) {
            if (entriesOfMap.getKey().equals("  + ") && repeatingKeys.get(entriesOfMap.getValue().getKey()) == 1) {
                result = result.concat("    " + entriesOfMap.getValue().getKey()
                        + ": " + entriesOfMap.getValue().getValue() + "\n");
            }
        }
        result = result.concat("  }\n  Unchanged: {\n");
        for (Map.Entry<String, Map.Entry<String, Object>> entriesOfMap: multimap.entries()) {
            if (entriesOfMap.getKey().equals("    ")) {
                result = result.concat("    " + entriesOfMap.getValue().getKey()
                        + ": " + entriesOfMap.getValue().getValue() + "\n");
            }
        }
        result = result.concat("  }\n  Updated: {\n");
        for (Map.Entry<String, Map.Entry<String, Object>> entriesOfMap: multimap.entries()) {
            if (entriesOfMap.getKey().equals("  - ") && repeatingKeys.get(entriesOfMap.getValue().getKey()) != 1) {
                result = result.concat("    " + entriesOfMap.getValue().getKey() + ": {\n      from: "
                        + entriesOfMap.getValue().getValue() + "\n      to: ");
            } else if (entriesOfMap.getKey().equals("  + ")
                    && repeatingKeys.get(entriesOfMap.getValue().getKey()) != 1) {
                result = result.concat(entriesOfMap.getValue().getValue() + "\n    }\n");
            }
        }
        result += "  }\n}";
        return result;
    }
}
