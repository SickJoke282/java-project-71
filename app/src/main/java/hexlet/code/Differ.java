package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Differ {
    public static String generate(File file1, File file2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "{\n";
        Map<String, Object> container1 = objectMapper.readValue(file1, HashMap.class);
        Map<String, Object> container2 = objectMapper.readValue(file2, HashMap.class);
        for (Map.Entry<String, Object> entryOfContainer1: container1.entrySet()) {
            if (container2.containsKey(entryOfContainer1.getKey())) {
                if (container2.get(entryOfContainer1.getKey()).equals(entryOfContainer1.getValue())) {
                    result += "   " + entryOfContainer1.getKey() + ": " + entryOfContainer1.getValue() + "\n";
                    container2.remove(entryOfContainer1.getKey());
                } else {
                    result += " - " + entryOfContainer1.getKey() + ": " + entryOfContainer1.getValue() + "\n";
                    result += " + " + entryOfContainer1.getKey() + ": " + container2.get(entryOfContainer1.getKey()) + "\n";
                    container2.remove(entryOfContainer1.getKey());
                }
            } else {
                result += " - " + entryOfContainer1.getKey() + ": " + entryOfContainer1.getValue() + "\n";
            }
        }
        for (Map.Entry<String, Object> entryOfContainer2: container2.entrySet()) {
            result += " + " + entryOfContainer2.getKey() + ": " + entryOfContainer2.getValue() + "\n";
        }
        result += "}";
        return result;
    }
}
