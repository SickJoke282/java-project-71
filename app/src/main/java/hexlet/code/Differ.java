package hexlet.code;

import java.io.IOException;
import java.nio.file.Path;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Differ {
    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
    }
    public static String generate(String file1, String file2, String formatter) throws IOException {
        Map<String, Object>[] parsedFiles = Parser.parse(Path.of(file1).toFile(), Path.of(file2).toFile());
        Map<String, Object> container1 = parsedFiles[0];
        Map<String, Object> container2 = parsedFiles[1];
        Map<Map.Entry<String, Object>, String> mapWithChanges = trackChangesOfFiles(container1, container2);
        return switch (formatter) {
            case "stylish" -> Formatter.stylishGenerate(mapWithChanges);
            case "plain" -> Formatter.plainGenerate(mapWithChanges);
            case "json" -> Formatter.jsonGenerate(mapWithChanges);
            default -> null;
        };
    }
    public static Map<Map.Entry<String, Object>, String> trackChangesOfFiles(Map<String,
            Object> container1, Map<String, Object> container2) {
        Map<Map.Entry<String, Object>, String> answer = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entryOfContainer1: container1.entrySet()) {
            if (container2.containsKey(entryOfContainer1.getKey())) {
                if (container2.get(entryOfContainer1.getKey()).equals(entryOfContainer1.getValue())) {
                    answer.put(Map.entry(entryOfContainer1.getKey(), entryOfContainer1.getValue()), "    ");
                    container2.remove(entryOfContainer1.getKey());
                } else {
                    answer.put(Map.entry(entryOfContainer1.getKey(), entryOfContainer1.getValue()),
                            "  - ");
                    answer.put(Map.entry(entryOfContainer1.getKey(), container2.get(entryOfContainer1.getKey())),
                            "  + ");
                    container2.remove(entryOfContainer1.getKey());
                }
            } else {
                answer.put(Map.entry(entryOfContainer1.getKey(), entryOfContainer1.getValue()), "  - ");
            }
        }
        for (Map.Entry<String, Object> entryOfContainer2: container2.entrySet()) {
            answer.put(Map.entry(entryOfContainer2.getKey(), entryOfContainer2.getValue()), "  + ");
        }
        return answer.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getKey().getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
