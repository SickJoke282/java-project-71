package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class DifferTestPlain {
    private static String expected;
    @BeforeAll
    public static void init() throws IOException {
        String expectedFile = "./src/test/resources/expectedFilePlain.txt";
        expected = Files.readString(Paths.get(expectedFile));
    }
    @Test
    void jsonTestTake() throws Exception {
        String file1 = "./src/test/resources/file1.json";
        String file2 = "./src/test/resources/file2.json";
        assertThat(Differ.generate(file1, file2, "plain"))
                .isEqualTo(expected);
    }
    @Test
    void ymlTestTake() throws Exception {
        String file1 = "./src/test/resources/file5.yml";
        String file2 = "./src/test/resources/file6.yml";
        assertThat(Differ.generate(file1, file2, "plain"))
                .isEqualTo(expected);
    }
}
