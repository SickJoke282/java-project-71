package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String plainGenerate(List<Map<String, Object>> mapsOfContent) {
        String result = "";
        for (Map<String, Object> content: mapsOfContent) {
            Object key = content.get("key");
            Object adaptiveValueToRead1 = giveAdaptiveOutput(content.get("value"));
            Object adaptiveValueToRead2 = null;
            if (content.containsKey("value2")) {
                adaptiveValueToRead2 = giveAdaptiveOutput(content.get("value2"));
            }
            switch (content.get("type").toString()) {
                case "removed":
                    result = result.concat("Property '" + key + "' was removed\n");
                    break;
                case "added":
                    result = result.concat("Property '" + key + "' was added with value: "
                        + adaptiveValueToRead1 + "\n");
                    break;
                case "changed":
                    result = result.concat("Property '" + key + "' was updated. From "
                        + adaptiveValueToRead1 + " to " + adaptiveValueToRead2 + "\n");
                    break;
                default: result = result.concat("");
            }
        }
        return result.substring(0, result.lastIndexOf('\n'));
    }
    public static Object giveAdaptiveOutput(Object value) {
        if (value.getClass() == LinkedHashMap.class || value.getClass() == ArrayList.class) {
            return "[complex value]";
        } else if (value.getClass() == String.class && !value.equals("null")) {
            return "'" + value + "'";
        } else {
            return value;
        }
    }
}
