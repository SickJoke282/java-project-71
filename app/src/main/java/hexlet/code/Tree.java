package hexlet.code;

import java.util.TreeSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class Tree {
    public static List<Map<String, Object>> trackChangesOfFiles(Map<String,
            Object> container1, Map<String, Object> container2) {
        List<Map<String, Object>> answer = new LinkedList<>();
        SortedSet<String> sortedSet = new TreeSet<>(container1.keySet());
        sortedSet.addAll(container2.keySet());
        for (String s: sortedSet) {
            if (!container2.containsKey(s)) {
                answer.add(Map.of("type", "removed", s, container1.get(s)));
            } else if (!container1.containsKey(s)) {
                answer.add(Map.of("type", "added", s, container2.get(s)));
            } else if (!container1.get(s).equals(container2.get(s))) {
                answer.add(Map.of("type", "changed", s, container1.get(s),
                        "value2", container2.get(s)));
            } else {
                answer.add(Map.of("type", "unchanged", s, container1.get(s)));
            }
        }
        return answer;
    }
}
