package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object>[] parse(File file1, File file2) throws IOException {
        Map<String, Object>[] parsedFiles = new HashMap[2];
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        ObjectMapper ymlObjectMapper = new YAMLMapper();
        if (file1.toString().contains(".json")) {
            parsedFiles[0] = jsonObjectMapper.readValue(file1, HashMap.class);
            parsedFiles[1] = jsonObjectMapper.readValue(file2, HashMap.class);
        } else if (file1.toString().contains(".yml")) {
            parsedFiles[0] = ymlObjectMapper.readValue(file1, HashMap.class);
            parsedFiles[1] = ymlObjectMapper.readValue(file2, HashMap.class);
        }
        parsedFiles[0].entrySet().forEach(x -> {
            if (x.getValue() == null) {
                x.setValue("null");
            }
        });
        return changeNulls(parsedFiles);
    }
    public static Map<String, Object>[] changeNulls(Map<String, Object>[] parsedFiles) {
        parsedFiles[0].entrySet().forEach(x -> {
            if (x.getValue() == null) {
                x.setValue("null");
            }
        });
        parsedFiles[1].entrySet().forEach(x -> {
            if (x.getValue() == null) {
                x.setValue("null");
            }
        });
        return parsedFiles;
    }
}
