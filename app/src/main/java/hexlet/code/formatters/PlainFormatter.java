package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlainFormatter {
    public static String plainGenerate(List<Map<String, Object>> maps) {
        String result = "";
        for (Map<String, Object> map: maps) {
            String key = map.keySet().stream()
                    .filter(x -> !x.equals("type") && !x.equals("value2"))
                    .collect(Collectors.joining());
            Object adaptiveValueToRead1 = giveAdaptiveOutput(map, key);
            Object adaptiveValueToRead2 = null;
            if (map.containsKey("value2")) {
                adaptiveValueToRead2 = giveAdaptiveOutput(map, "value2");
            }
            if (map.get("type").equals("removed")) {
                result = result.concat("Property '" + key + "' was removed\n");
            } else if (map.get("type").equals("added")) {
                result = result.concat("Property '" + key + "' was added with value: "
                        + adaptiveValueToRead1 + "\n");
            } else if (map.get("type").equals("changed")) {
                result = result.concat("Property '" + key + "' was updated. From "
                        + adaptiveValueToRead1 + " to " + adaptiveValueToRead2 + "\n");
            }
        }
        return result.substring(0, result.lastIndexOf('\n'));
    }
    public static Object giveAdaptiveOutput(Map<String, Object> map, String key) {
        return (map.get(key).getClass() == LinkedHashMap.class
                || map.get(key).getClass() == ArrayList.class)
                ? "[complex value]" : (map.get(key).getClass() == String.class
                && !map.get(key).equals("null"))
                ? "'" + map.get(key) + "'" : map.get(key);
    }
}
