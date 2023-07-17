package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(
            String contentOfFile,
            String extension
    ) throws IOException {
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        ObjectMapper ymlObjectMapper = new YAMLMapper();
        return switch (extension) {
            case ".json" -> jsonObjectMapper.readValue(contentOfFile, Map.class);
            case ".yml" -> ymlObjectMapper.readValue(contentOfFile, Map.class);
            default -> null;
        };
    }
}
