package hexlet.code.formatters;

import hexlet.code.Formatter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlainFormatter {
    public static String plainGenerate(List<Map<String, Object>> maps) {
        String result = "";
        for (Map<String, Object> map: maps) {
            Object temp2 = null;
            if (map.containsKey("value2")) {
                temp2 = Formatter.changeValueForReading(map.entrySet().stream()
                        .filter(x -> x.getKey().equals("value2"))
                        .collect(Collectors.toSet()), "plain");
            }
            Object temp = Formatter.changeValueForReading(map.entrySet().stream()
                    .filter(x -> !x.getKey().equals("type") && !x.getKey().equals("value2"))
                    .collect(Collectors.toSet()), "plain");
            String s = map.keySet().stream()
                    .filter(x -> !x.equals("type") && !x.equals("value2"))
                    .collect(Collectors.joining());
            if (map.get("type").equals("removed")) {
                result = result.concat("Property '" + s + "' was removed\n");
            } else if (map.get("type").equals("added")) {
                result = result.concat("Property '" + s + "' was added with value: "
                        + temp + "\n");
            } else if (map.get("type").equals("changed")) {
                result = result.concat("Property '" + s + "' was updated. From "
                        + temp + " to " + temp2 + "\n");
            }
        }
        return result;
    }
}
