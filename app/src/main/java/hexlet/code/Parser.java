package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object>[] parse(
            String file1,
            String file2,
            String extension
    ) throws IOException {
        Map<String, Object>[] parsedFiles = new HashMap[2];
        if (extension.equals(".json")) {
            ObjectMapper jsonObjectMapper = new ObjectMapper();
            parsedFiles[0] = jsonObjectMapper.readValue(file1, HashMap.class);
            parsedFiles[1] = jsonObjectMapper.readValue(file2, HashMap.class);
        } else if (extension.equals(".yml")) {
            ObjectMapper ymlObjectMapper = new YAMLMapper();
            parsedFiles[0] = ymlObjectMapper.readValue(file1, HashMap.class);
            parsedFiles[1] = ymlObjectMapper.readValue(file2, HashMap.class);
        }
        return parsedFiles;
    }
}
