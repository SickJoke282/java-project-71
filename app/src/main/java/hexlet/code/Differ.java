package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class Differ {
    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
    }
    public static String generate(String file1, String file2, String formatter) throws IOException {
        String contentOfFile1 = Files.readString(Paths.get(file1));
        String contentOfFile2 = Files.readString(Paths.get(file2));
        String extension = file1.substring(file1.lastIndexOf('.'));
        Map<String, Object>[] parsedFiles = Parser.parse(contentOfFile1, contentOfFile2, extension);
        Map<String, Object> container1 = parsedFiles[0];
        Map<String, Object> container2 = parsedFiles[1];
        List<Map<String, Object>> mapWithChanges = Tree.trackChangesOfFiles(container1, container2);
        return Formatter.defineAFormatter(mapWithChanges, formatter);
    }

}
