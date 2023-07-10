package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Formatter {
    public static Map<String, Integer> findRepeatingKeys(Map<Map.Entry<String, Object>, String> multimap) {
        Map<String, Integer> repeatingKeys = new LinkedHashMap<>();
        int count = 1;
        for (Map.Entry<Map.Entry<String, Object>, String> entriesOfMap: multimap.entrySet()) {
            if (repeatingKeys.containsKey(entriesOfMap.getKey().getKey())) {
                int temp = count + 1;
                repeatingKeys.put(entriesOfMap.getKey().getKey(), temp);
                continue;
            }
            repeatingKeys.put(entriesOfMap.getKey().getKey(), count);
        }
        return repeatingKeys;
    }
    public static String stylishGenerate(Map<Map.Entry<String, Object>, String> multimap) {
        String result = "{\n";
        for (Map.Entry<Map.Entry<String, Object>, String> entriesOfMap: multimap.entrySet()) {
            result = result.concat(entriesOfMap.getValue() + entriesOfMap.getKey().getKey()
                    + ": " +  entriesOfMap.getKey().getValue() + "\n");
        }
        result = result.concat("}");
        return result;
    }
    public static String plainGenerate(Map<Map.Entry<String, Object>, String> multimap) {
        String result = "";
        Map<String, Integer> repeatingKeys = findRepeatingKeys(multimap);
        for (Map.Entry<Map.Entry<String, Object>, String> entriesOfMap: multimap.entrySet()) {
            Object temp = (entriesOfMap.getKey().getValue().getClass() == LinkedHashMap.class
                    || entriesOfMap.getKey().getValue().getClass() == ArrayList.class)
                    ? "[complex value]" : (entriesOfMap.getKey().getValue().getClass() == String.class
                            && !entriesOfMap.getKey().getValue().equals("null"))
                    ? "'" + entriesOfMap.getKey().getValue() + "'" : entriesOfMap.getKey().getValue();
            if (entriesOfMap.getValue().equals("    ")) {
                continue;
            }
            if (entriesOfMap.getValue().equals("  - ") && repeatingKeys.get(entriesOfMap.getKey().getKey()) == 1) {
                result = result.concat("Property '" + entriesOfMap.getKey().getKey() + "' was removed\n");
            } else if (entriesOfMap.getValue().equals("  + ")
                    && repeatingKeys.get(entriesOfMap.getKey().getKey()) == 1) {
                result = result.concat("Property '" + entriesOfMap.getKey().getKey() + "' was added with value: "
                        + temp + "\n");
            } else {
                if (entriesOfMap.getValue().equals("  - ")) {
                    result = result.concat("Property '" + entriesOfMap.getKey().getKey() + "' was updated. From "
                            + temp + " to ");
                    continue;
                }
                result = result.concat(temp + "\n");
            }
        }
        return result.substring(0, result.length() - 1);
    }
    public static String jsonGenerate(Map<Map.Entry<String, Object>, String> multimap) {
        Map<String, Integer> repeatingKeys = findRepeatingKeys(multimap);
        String result = "{\n  \"Added\": {\n";
        for (Map.Entry<Map.Entry<String, Object>, String> entriesOfMap: multimap.entrySet()) {
            Object temp = giveComplexValueOrCasual(entriesOfMap);
            if (entriesOfMap.getValue().equals("  + ") && repeatingKeys.get(entriesOfMap.getKey().getKey()) == 1) {
                result = result.concat("    \"" + entriesOfMap.getKey().getKey()
                        + "\": " + temp  + ",\n");
            }
        }
        result = result.substring(0, result.length() - 2).concat("\n  },\n  \"Removed\": {\n");
        for (Map.Entry<Map.Entry<String, Object>, String> entriesOfMap: multimap.entrySet()) {
            Object temp = giveComplexValueOrCasual(entriesOfMap);
            if (entriesOfMap.getValue().equals("  - ") && repeatingKeys.get(entriesOfMap.getKey().getKey()) == 1) {
                result = result.concat("    \"" + entriesOfMap.getKey().getKey()
                        + "\": " + temp + ",\n");
            }
        }
        result = result.substring(0, result.length() - 2).concat("\n  },\n  \"Unchanged\": {\n");
        for (Map.Entry<Map.Entry<String, Object>, String> entriesOfMap: multimap.entrySet()) {
            Object temp = giveComplexValueOrCasual(entriesOfMap);
            if (entriesOfMap.getValue().equals("    ")) {
                result = result.concat("    \"" + entriesOfMap.getKey().getKey()
                        + "\": " + temp + ",\n");
            }
        }
        result = result.substring(0, result.length() - 2).concat("\n  },\n  \"Updated\": {\n");
        for (Map.Entry<Map.Entry<String, Object>, String> entriesOfMap: multimap.entrySet()) {
            Object temp = giveComplexValueOrCasual(entriesOfMap);
            if (entriesOfMap.getValue().equals("  - ") && repeatingKeys.get(entriesOfMap.getKey().getKey()) != 1) {
                result = result.concat("    \"" + entriesOfMap.getKey().getKey() + "\": {\n      \"from\": "
                        + temp + ",\n      \"to\": ");
            } else if (entriesOfMap.getValue().equals("  + ")
                    && repeatingKeys.get(entriesOfMap.getKey().getKey()) != 1) {
                result = result.concat(temp + "\n    },\n");
            }
        }
        result += result.substring(0, result.length() - 2).concat("\n  }\n}");
        return result;
    }
    public static Object giveComplexValueOrCasual(Map.Entry<Map.Entry<String, Object>, String> entriesOfMap) {
        return (entriesOfMap.getKey().getValue().getClass() == LinkedHashMap.class
                || entriesOfMap.getKey().getValue().getClass() == ArrayList.class)
                ? "\"[complex value]\"" : (entriesOfMap.getKey().getValue().getClass() == String.class
                && !entriesOfMap.getKey().getValue().equals("null"))
                ? "\"" + entriesOfMap.getKey().getValue() + "\"" : entriesOfMap.getKey().getValue();
    }
}