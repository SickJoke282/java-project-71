package hexlet.code;

import java.util.TreeSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class Tree {
    public static List<Map<String, Object>> trackChangesOfFiles(
            Map<String, Object> container1,
            Map<String, Object> container2
    ) {
        List<Map<String, Object>> answer = new LinkedList<>();
        SortedSet<String> sortedSet = new TreeSet<>(container1.keySet());
        sortedSet.addAll(container2.keySet());
        for (String key: sortedSet) {
            Object val1 = (container1.get(key) == null ? "null" : container1.get(key));
            Object val2 = (container2.get(key) == null ? "null" : container2.get(key));
            if (!container2.containsKey(key)) {
                Map<String, Object> node = Map.of(
                        "type", "removed",
                        key, val1
                );
                answer.add(node);
            } else if (!container1.containsKey(key)) {
                Map<String, Object> node = Map.of(
                        "type", "added",
                        key, val2
                );
                answer.add(node);
            } else if (!val1.equals(val2)) {
                Map<String, Object> node = Map.of(
                        "type", "changed",
                        key, val1,
                        "value2", val2
                );
                answer.add(node);
            } else {
                Map<String, Object> node = Map.of(
                        "type", "unchanged",
                        key, val1
                );
                answer.add(node);
            }
        }
        return answer;
    }
}
