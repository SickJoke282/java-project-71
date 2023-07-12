package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class Formatter {
    public static String defineAFormatter(List<Map<String, Object>> mapWithChanges, String formatter)
            throws JsonProcessingException {
        return switch (formatter) {
            case "stylish" -> StylishFormatter.stylishGenerate(mapWithChanges);
            case "plain" -> PlainFormatter.plainGenerate(mapWithChanges);
            case "json" -> JsonFormatter.jsonGenerate(mapWithChanges);
            default -> null;
        };
    }
    public static Object changeValueForReading(Set<Map.Entry<String, Object>> entries, String formatter) {
        return (entries.iterator().next().getValue().getClass() == LinkedHashMap.class
                || entries.iterator().next().getValue().getClass() == ArrayList.class)
                ? (formatter.equals("json") ? "\"[complex value]\"" : "[complex value]")
                : (entries.iterator().next().getValue().getClass() == String.class
                && !entries.iterator().next().getValue().equals("null"))
                ? (formatter.equals("json") ? "\"" + entries.iterator().next().getValue() + "\""
                : "'" + entries.iterator().next().getValue() + "'")
                : entries.iterator().next().getValue();
    }
}
