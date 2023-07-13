package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

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
}
