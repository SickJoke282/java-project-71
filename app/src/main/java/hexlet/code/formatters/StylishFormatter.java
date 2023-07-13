package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StylishFormatter {
    public static String stylishGenerate(List<Map<String, Object>> maps) {
        String result = "{\n";
        for (Map<String, Object> map: maps) {
            String key = map.keySet().stream()
                    .filter(x -> !x.equals("type") && !x.equals("value2"))
                    .collect(Collectors.joining());
            switch (map.get("type").toString()) {
                case "removed":
                    result = result.concat("  - " + key
                        + ": " +  map.get(key) + "\n");
                    break;
                case "added":
                    result = result.concat("  + " + key
                        + ": " +  map.get(key) + "\n");
                    break;
                case "changed":
                    result = result.concat("  - " + key
                            + ": " + map.get(key) + "\n");
                    result = result.concat("  + " + key
                            + ": " + map.get("value2") + "\n");
                    break;
                default:
                    result = result.concat("    " + key
                        + ": " +  map.get(key) + "\n");
            }
        }
        result = result.concat("}");
        return result;
    }
}
