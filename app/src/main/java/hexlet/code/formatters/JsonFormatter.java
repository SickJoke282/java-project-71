package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonFormatter {
    public static String jsonGenerate(List<Map<String, Object>> maps) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        Map<String, Map<String, Object>> newMap = new LinkedHashMap<>();
        Map<String, Object> added = new LinkedHashMap<>();
        Map<String, Object> removed = new LinkedHashMap<>();
        Map<String, Object> unchanged = new LinkedHashMap<>();
        Map<String, Object> changed = new LinkedHashMap<>();
        String result = "";
        for (Map<String, Object> map: maps) {
            String s = map.keySet().stream()
                    .filter(x -> !x.equals("type") && !x.equals("value2"))
                    .collect(Collectors.joining());
            if (map.get("type").equals("added")) {
                added.putAll(map);
                added.remove("type");
            } else if (map.get("type").equals("removed")) {
                removed.putAll(map);
                removed.remove("type");
            } else if (map.get("type").equals("unchanged")) {
                unchanged.putAll(map);
                unchanged.remove("type");
            } else {
                changed.put(s, Map.of("from", map.get(s), "to", map.get("value2")));
                changed.remove("type");
            }
            newMap.put("added", added);
            newMap.put("removed", removed);
            newMap.put("unchanged", unchanged);
            newMap.put("changed", changed);
            result = result.concat(objectMapper.writeValueAsString(map));
        }
        result = objectMapper.writeValueAsString(newMap);
        return result;
    }
}
