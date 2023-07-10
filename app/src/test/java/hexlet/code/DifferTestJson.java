package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.junit.jupiter.api.Test;

class DifferTestJson {
    @Test
    void jsonTestTake() throws Exception {
        File file1 = new File("./src/test/resources/file1.json");
        File file2 = new File("./src/test/resources/file2.json");
        String[] expected = {
            "{",
            "  Removed: {\n    key1: value1\n    numbers3: [3, 4, 5]",
            "  Added: {\n    key2: value2\n    numbers4: [4, 5, 6]\n    obj1: {nestedKey=value, isNested=true}",
            "  Unchanged: {\n    chars1: [a, b, c]\n    numbers1: [1, 2, 3, 4]",
            "  Updated: {\n    setting2: {\n      from: 200\n      to: 300\n    }",
            "    setting3: {\n      from: true\n      to: none\n    }",
            "    default: {\n      from: null\n      to: [value1, value2]\n    }",
            "    chars2: {\n      from: [d, e, f]\n      to: false\n    }",
            "    setting1: {\n      from: Some value\n      to: Another value\n    }",
            "    numbers2: {\n      from: [2, 3, 4, 5]\n      to: [22, 33, 44, 55]\n    }",
            "    checked: {\n      from: false\n      to: true\n    }",
            "    id: {\n      from: 45\n      to: null\n    }",
            "  }\n}"
        };
        assertThat(Differ.generate(file1, file2, "json")).contains(expected);
    }
    @Test
    void ymlTestTake() throws Exception {
        File file1 = new File("./src/test/resources/file5.yml");
        File file2 = new File("./src/test/resources/file6.yml");
        String[] expected = {
            "{",
            "  Removed: {\n    key1: value1\n    numbers3: [3, 4, 5]",
            "  Added: {\n    key2: value2\n    numbers4: [4, 5, 6]\n    obj1: {nestedKey=value, isNested=true}",
            "  Unchanged: {\n    chars1: [a, b, c]\n    numbers1: [1, 2, 3, 4]",
            "  Updated: {\n    setting2: {\n      from: 200\n      to: 300\n    }",
            "    setting3: {\n      from: true\n      to: none\n    }",
            "    default: {\n      from: null\n      to: [value1, value2]\n    }",
            "    chars2: {\n      from: [d, e, f]\n      to: false\n    }",
            "    setting1: {\n      from: Some value\n      to: Another value\n    }",
            "    numbers2: {\n      from: [2, 3, 4, 5]\n      to: [22, 33, 44, 55]\n    }",
            "    checked: {\n      from: false\n      to: true\n    }",
            "    id: {\n      from: 45\n      to: null\n    }",
            "  }\n}"
        };
        assertThat(Differ.generate(file1, file2, "json")).contains(expected);
    }
}
