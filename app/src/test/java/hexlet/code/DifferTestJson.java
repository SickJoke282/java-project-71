package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DifferTestJson {
    @Test
    void jsonTestTake() throws Exception {
        String file1 = "./src/test/resources/file1.json";
        String file2 = "./src/test/resources/file2.json";
        String[] expected = {
            "{",
            "\"added\" : {", "\"key2\" : \"value2\"",    "\"numbers4\" : [ 4, 5, 6 ]",
            "\"obj1\" : {",
            "\"nestedKey\" : \"value\",\n",
            "\"isNested\" : true\n",
            "\"removed\" : {", "\"key1\" : \"value1\"", "\"numbers3\" : [ 3, 4, 5 ]",
            "\"unchanged\" : {", "\"chars1\" : [ \"a\", \"b\", \"c\" ]", "\"numbers1\" : [ 1, 2, 3, 4 ]",
            "\"changed\" : {", "\"chars2\" : {", "from\" : [ \"d\", \"e\", \"f\" ]", "\"to\" : false",
            "\"checked\" : {\n", "\"from\" : false", "\"to\" : true",
            "\"default\" : {", "\"from\" : \"null\"", "\"to\" : [ \"value1\", \"value2\" ]",
            "\"id\" : {", "\"from\" : 45", "\"to\" : \"null\"",
            "\"numbers2\" : {", "\"from\" : [ 2, 3, 4, 5 ]", "\"to\" : [ 22, 33, 44, 55 ]",
            "\"setting1\" : {", "\"from\" : \"Some value\"", "\"to\" : \"Another value\"",
            "\"setting2\" : {", "\"from\" : 200", "\"to\" : 300",
            "\"setting3\" : {", "\"from\" : true", "\"to\" : \"none\""
        };
        assertThat(Differ.generate(file1, file2, "json")).contains(expected);
    }
    @Test
    void ymlTestTake() throws Exception {
        String file1 = "./src/test/resources/file5.yml";
        String file2 = "./src/test/resources/file6.yml";
        String[] expected = {
            "{",
            "\"added\" : {", "\"key2\" : \"value2\"",    "\"numbers4\" : [ 4, 5, 6 ]",
            "\"obj1\" : {",
            "\"nestedKey\" : \"value\",\n",
            "\"isNested\" : true\n",
            "\"removed\" : {", "\"key1\" : \"value1\"", "\"numbers3\" : [ 3, 4, 5 ]",
            "\"unchanged\" : {", "\"chars1\" : [ \"a\", \"b\", \"c\" ]", "\"numbers1\" : [ 1, 2, 3, 4 ]",
            "\"changed\" : {", "\"chars2\" : {", "from\" : [ \"d\", \"e\", \"f\" ]", "\"to\" : false",
            "\"checked\" : {\n", "\"from\" : false", "\"to\" : true",
            "\"default\" : {", "\"from\" : \"null\"", "\"to\" : [ \"value1\", \"value2\" ]",
            "\"id\" : {", "\"from\" : 45", "\"to\" : \"null\"",
            "\"numbers2\" : {", "\"from\" : [ 2, 3, 4, 5 ]", "\"to\" : [ 22, 33, 44, 55 ]",
            "\"setting1\" : {", "\"from\" : \"Some value\"", "\"to\" : \"Another value\"",
            "\"setting2\" : {", "\"from\" : 200", "\"to\" : 300",
            "\"setting3\" : {", "\"from\" : true", "\"to\" : \"none\""
        };
        assertThat(Differ.generate(file1, file2, "json")).contains(expected);
    }
}
