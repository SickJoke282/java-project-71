package hexlet.code;

import java.io.IOException;
import java.nio.file.Path;

import java.util.List;
import java.util.Map;


public class Differ {
    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
    }
    public static String generate(String file1, String file2, String formatter) throws IOException {
        Map<String, Object>[] parsedFiles = Parser.parse(Path.of(file1).toFile(), Path.of(file2).toFile());
        Map<String, Object> container1 = parsedFiles[0];
        Map<String, Object> container2 = parsedFiles[1];
        List<Map<String, Object>> mapWithChanges = Tree.trackChangesOfFiles(container1, container2);
        return Formatter.defineAFormatter(mapWithChanges, formatter);
    }

}
