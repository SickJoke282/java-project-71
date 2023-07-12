package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StylishFormatter {
    public static String stylishGenerate(List<Map<String, Object>> maps) {
        String result = "{\n";
        for (Map<String, Object> map: maps) {
            String s = map.keySet().stream()
                    .filter(x -> !x.equals("type") && !x.equals("value2"))
                    .collect(Collectors.joining());
            if (map.get("type").equals("removed")) {
                result = result.concat("  - " + s
                        + ": " +  map.get(s) + "\n");
            } else if (map.get("type").equals("added")) {
                result = result.concat("  + " + s
                        + ": " +  map.get(s) + "\n");
            } else if (map.get("type").equals("changed")) {
                result = result.concat("  - " + s
                        + ": " +  map.get(s) + "\n");
                result = result.concat("  + " + s
                        + ": " +  map.get("value2") + "\n");
            } else {
                result = result.concat("    " + s
                        + ": " +  map.get(s) + "\n");
            }
        }
        result = result.concat("}");
        return result;
    }
}
