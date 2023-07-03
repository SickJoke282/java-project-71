package hexlet.code;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import java.io.File;
import java.io.IOException;
import java.util.Map;


public class Differ {
    public static String generate(File file1, File file2, String formatter) throws IOException {
        Map<String, Object>[] parsedFiles = Parser.parse(file1, file2);
        Map<String, Object> container1 = parsedFiles[0];
        Map<String, Object> container2 = parsedFiles[1];
        Multimap<String, Map.Entry<String, Object>> answer = trackChangesOfFiles(container1, container2);
        return switch (formatter) {
            case "stylish" -> Formatter.stylishGenerate(answer);
            case "plain" -> Formatter.plainGenerate(answer);
            default -> null;
        };
    }
    public static Multimap<String, Map.Entry<String, Object>> trackChangesOfFiles(Map<String,
            Object> container1, Map<String, Object> container2) {
        Multimap<String, Map.Entry<String, Object>> answer = LinkedHashMultimap.create();
        for (Map.Entry<String, Object> entryOfContainer1: container1.entrySet()) {
            if (container2.containsKey(entryOfContainer1.getKey())) {
                if (container2.get(entryOfContainer1.getKey()).equals(entryOfContainer1.getValue())) {
                    answer.put("    ", Map.entry(entryOfContainer1.getKey(), entryOfContainer1.getValue()));
                    container2.remove(entryOfContainer1.getKey());
                } else {
                    answer.put("  - ",
                            Map.entry(entryOfContainer1.getKey(), entryOfContainer1.getValue()));
                    answer.put("  + ",
                            Map.entry(entryOfContainer1.getKey(), container2.get(entryOfContainer1.getKey())));
                    container2.remove(entryOfContainer1.getKey());
                }
            } else {
                answer.put("  - ", Map.entry(entryOfContainer1.getKey(), entryOfContainer1.getValue()));
            }
        }
        for (Map.Entry<String, Object> entryOfContainer2: container2.entrySet()) {
            answer.put("  + ", Map.entry(entryOfContainer2.getKey(), entryOfContainer2.getValue()));
        }
        return answer;
    }
}
