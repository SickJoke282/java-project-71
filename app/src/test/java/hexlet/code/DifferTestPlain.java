package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DifferPlainTest {
    @Test
    void jsonTestTake() throws Exception {
        String file1 = "./src/test/resources/file1.json";
        String file2 = "./src/test/resources/file2.json";
        String[] expected = {
            "Property 'chars2' was updated. From [complex value] to false",
            "Property 'checked' was updated. From false to true",
            "Property 'default' was updated. From null to [complex value]",
            "Property 'key1' was removed",
            "Property 'key2' was added with value: value2",
            "Property 'numbers2' was updated. From [complex value] to [complex value]",
            "Property 'numbers3' was removed",
            "Property 'numbers4' was added with value: [complex value]",
            "Property 'obj1' was added with value: [complex value]",
            "Property 'setting1' was updated. From Some value to Another value",
            "Property 'setting2' was updated. From 200 to 300",
            "Property 'setting3' was updated. From true to none"
            };
        assertThat(Differ.generate(file1, file2, "plain")).contains(expected);
    }
    @Test
    void ymlTestTake() throws Exception {
        String file1 = "./src/test/resources/file5.yml";
        String file2 = "./src/test/resources/file6.yml";
        String[] expected = {
            "Property 'chars2' was updated. From [complex value] to false",
            "Property 'checked' was updated. From false to true",
            "Property 'default' was updated. From null to [complex value]",
            "Property 'key1' was removed",
            "Property 'key2' was added with value: value2",
            "Property 'numbers2' was updated. From [complex value] to [complex value]",
            "Property 'numbers3' was removed",
            "Property 'numbers4' was added with value: [complex value]",
            "Property 'obj1' was added with value: [complex value]",
            "Property 'setting1' was updated. From Some value to Another value",
            "Property 'setting2' was updated. From 200 to 300",
            "Property 'setting3' was updated. From true to none"
            };
        assertThat(Differ.generate(file1, file2, "plain")).contains(expected);
    }
}
