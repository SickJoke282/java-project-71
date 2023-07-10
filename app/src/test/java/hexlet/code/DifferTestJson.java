package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DifferTestJson {
    @Test
    void jsonTestTake() throws Exception {
        String file1 = "./src/test/resources/file1.json";
        String file2 = "./src/test/resources/file2.json";
        String[] expected = {
            "{\n",
            "  \"Added\": {\n    \"key2\": \"value2\",\n    \"numbers4\": \"[complex value]\",\n"
                + "    \"obj1\": \"[complex value]\"\n  },\n",
            "  \"Removed\": {\n    \"key1\": \"value1\",\n    \"numbers3\": \"[complex value]\"\n"
                + "  },\n",
            "  \"Unchanged\": {\n    \"chars1\": \"[complex value]\",\n    \"numbers1\": \"[complex value]\"\n"
                + "  },\n",
            "  \"Updated\": {\n    \"chars2\": {\n      \"from\": \"[complex value]\",\n      \"to\": false\n"
                + "    },\n    \"checked\": {\n      \"from\": false,\n      \"to\": true\n    },\n"
                + "    \"default\": {\n      \"from\": null,\n      \"to\": \"[complex value]\"\n"
                + "    },\n    \"id\": {\n      \"from\": 45,\n      \"to\": null\n    },\n"
                + "    \"numbers2\": {\n      \"from\": \"[complex value]\",\n      \"to\": \"[complex value]\"\n"
                + "    },\n    \"setting1\": {\n      \"from\": \"Some value\",\n      \"to\": \"Another value\"\n"
                + "    },\n    \"setting2\": {\n      \"from\": 200,\n      \"to\": 300\n    },\n"
                + "    \"setting3\": {\n      \"from\": true,\n      \"to\": \"none\"\n    }\n  }\n}"
        };
        assertThat(Differ.generate(file1, file2, "json")).contains(expected);
    }
    @Test
    void ymlTestTake() throws Exception {
        String file1 = "./src/test/resources/file5.yml";
        String file2 = "./src/test/resources/file6.yml";
        String[] expected = {
            "{\n",
            "  \"Added\": {\n    \"key2\": \"value2\",\n    \"numbers4\": \"[complex value]\",\n"
                + "    \"obj1\": \"[complex value]\"\n  },\n",
            "  \"Removed\": {\n    \"key1\": \"value1\",\n    \"numbers3\": \"[complex value]\"\n"
                + "  },\n",
            "  \"Unchanged\": {\n    \"chars1\": \"[complex value]\",\n    \"numbers1\": \"[complex value]\"\n"
                + "  },\n",
            "  \"Updated\": {\n    \"chars2\": {\n      \"from\": \"[complex value]\",\n      \"to\": false\n"
                + "    },\n    \"checked\": {\n      \"from\": false,\n      \"to\": true\n    },\n"
                + "    \"default\": {\n      \"from\": null,\n      \"to\": \"[complex value]\"\n"
                + "    },\n    \"id\": {\n      \"from\": 45,\n      \"to\": null\n    },\n"
                + "    \"numbers2\": {\n      \"from\": \"[complex value]\",\n      \"to\": \"[complex value]\"\n"
                + "    },\n    \"setting1\": {\n      \"from\": \"Some value\",\n      \"to\": \"Another value\"\n"
                + "    },\n    \"setting2\": {\n      \"from\": 200,\n      \"to\": 300\n    },\n"
                + "    \"setting3\": {\n      \"from\": true,\n      \"to\": \"none\"\n    }\n  }\n}"
        };
        assertThat(Differ.generate(file1, file2, "json")).contains(expected);
    }
}
