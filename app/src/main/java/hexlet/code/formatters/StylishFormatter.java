package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String stylishGenerate(List<Map<String, Object>> mapsOfContent) {
        String result = "{\n";
        for (Map<String, Object> content: mapsOfContent) {
            Object key = content.get("key");
            Object value = content.get("value");
            switch (content.get("type").toString()) {
                case "removed":
                    result = result.concat("  - " + key + ": " +  value + "\n");
                    break;
                case "added":
                    result = result.concat("  + " + key + ": " +  value + "\n");
                    break;
                case "changed":
                    result = result.concat("  - " + key + ": " + value + "\n");
                    result = result.concat("  + " + key + ": " + content.get("value2") + "\n");
                    break;
                default:
                    result = result.concat("    " + key + ": " +  value + "\n");
            }
        }
        result = result.concat("}");
        return result;
    }
}
