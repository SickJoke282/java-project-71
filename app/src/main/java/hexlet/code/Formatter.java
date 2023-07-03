package hexlet.code;

import java.util.Map;

public class Stylish {
    public static String generate(Map<String, Object> container1, Map<String, Object> container2) {
        String result = "{\n";
        for (Map.Entry<String, Object> entryOfContainer1: container1.entrySet()) {
            if (container2.containsKey(entryOfContainer1.getKey())) {
                System.out.println(entryOfContainer1.getValue());
                if (container2.get(entryOfContainer1.getKey()).equals(entryOfContainer1.getValue())) {
                    result += "   " + entryOfContainer1.getKey() + ": " + entryOfContainer1.getValue() + "\n";
                    container2.remove(entryOfContainer1.getKey());
                } else {
                    result += " - " + entryOfContainer1.getKey() + ": " + entryOfContainer1.getValue() + "\n";
                    result += " + " + entryOfContainer1.getKey()
                            + ": " + container2.get(entryOfContainer1.getKey())
                            + "\n";
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
