package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String stylishGenerate(List<Map<String, Object>> mapsOfContent) {
        String result = "{\n";
        for (Map<String, Object> content: mapsOfContent) {
            Object key = content.get("key");
            key = key.toString();
            switch (content.get("type").toString()) {
                case "removed":
                    result = result.concat("  - " + key + ": " +  content.get(key) + "\n");
                    break;
                case "added":
                    result = result.concat("  + " + key + ": " +  content.get(key) + "\n");
                    break;
                case "changed":
                    result = result.concat("  - " + key + ": " + content.get(key) + "\n");
                    result = result.concat("  + " + key + ": " + content.get("value2") + "\n");
                    break;
                default:
                    result = result.concat("    " + key + ": " +  content.get(key) + "\n");
            }
        }
        result = result.concat("}");
        return result;
    }
}
