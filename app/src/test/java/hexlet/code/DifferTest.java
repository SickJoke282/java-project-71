package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;


import org.junit.jupiter.api.Test;

class DifferTest {

    @Test
    void jsonTestTake() throws Exception {
        File file1 = new File("./src/test/resources/file1.json");
        File file2 = new File("./src/test/resources/file2.json");
        String[] expected = {
            "{",
            "chars1: [a, b, c]",
            "- chars2: [d, e, f]",
            "+ chars2: false",
            "- checked: false",
            "+ checked: true",
            "- default: null",
            "+ default: [value1, value2]",
            "- id: 45",
            "+ id: null",
            "- key1: value1",
            "+ key2: value2",
            "numbers1: [1, 2, 3, 4]",
            "- numbers2: [2, 3, 4, 5]",
            "+ numbers2: [22, 33, 44, 55]",
            "- numbers3: [3, 4, 5]",
            "+ numbers4: [4, 5, 6]",
            "+ obj1: {nestedKey=value, isNested=true}",
            "- setting1: Some value",
            "+ setting1: Another value",
            "- setting2: 200",
            "+ setting2: 300",
            "- setting3: true",
            "+ setting3: none",
            "}"
            };
        assertThat(Differ.generate(file1, file2, "stylish")).contains(expected);
    }

    @Test
    void jsonTestTake2() throws Exception {
        File file1 = new File("./src/test/resources/file3.json");
        File file2 = new File("./src/test/resources/file4.json");
        String[] expected = {
            "{",
            "- gender: female",
            "+ gender: unknown",
            "- index: 0",
            "+ index: 1",
            "- guid: a22364b0-8c62-478a-8a26-5b7519e45c1a",
            "+ guid: adsbsadgsdb0-8c62-478a-8a26-5b7519e45c1a",
            "- picture: http://placehold.it/32x32",
            "- balance: $1,297.30",
            "+ balance: $62345,297.30",
            "- eyeColor: brown",
            "  phone: +1 (883) 543-3337",
            "  name: Darla Sawyer",
            "- company: PASTURIA",
            "+ company: HaHARIA",
            "- isActive: false",
            "+ isActive: true",
            "- _id: 649aaa8a5f9b151acad0b0e0",
            "+ _id: 64999995f9b151acagasdgsdagd0b0e0",
            "  age: 37",
            "- email: darlasawyer@pasturia.com",
            "+ email: darlasadfsdg@ia.com",
            "+ favoriteFruit: banana",
            "+ address: 495 Chestnut Street, Caron, Tennessee, 1102",
            "+ greeting: Hello, Darla Sawyer! You have 4 unread messages.",
            "}"
            };
        assertThat(Differ.generate(file1, file2, "stylish")).contains(expected);
    }
    @Test
    void ymlTestTake() throws Exception {
        File file1 = new File("./src/test/resources/file5.yml");
        File file2 = new File("./src/test/resources/file6.yml");
        String[] expected = {
            "{",
            "chars1: [a, b, c]",
            "- chars2: [d, e, f]",
            "+ chars2: false",
            "- checked: false",
            "+ checked: true",
            "- default: null",
            "+ default: [value1, value2]",
            "- id: 45",
            "+ id: null",
            "- key1: value1",
            "+ key2: value2",
            "numbers1: [1, 2, 3, 4]",
            "- numbers2: [2, 3, 4, 5]",
            "+ numbers2: [22, 33, 44, 55]",
            "- numbers3: [3, 4, 5]",
            "+ numbers4: [4, 5, 6]",
            "+ obj1: {nestedKey=value, isNested=true}",
            "- setting1: Some value",
            "+ setting1: Another value",
            "- setting2: 200",
            "+ setting2: 300",
            "- setting3: true",
            "+ setting3: none",
            "}"
        };
        assertThat(Differ.generate(file1, file2, "stylish")).contains(expected);
    }
    @Test
    void ymlTestTake2() throws Exception {
        File file1 = new File("./src/test/resources/file7.yml");
        File file2 = new File("./src/test/resources/file8.yml");
        String[] expected = {
            "{",
            "- gender: female",
            "+ gender: unknown",
            "- index: 0",
            "+ index: 1",
            "- guid: a22364b0-8c62-478a-8a26-5b7519e45c1a",
            "+ guid: adsbsadgsdb0-8c62-478a-8a26-5b7519e45c1a",
            "- picture: http://placehold.it/32x32",
            "- balance: $1,297.30",
            "+ balance: $62345,297.30",
            "- eyeColor: brown",
            "  phone: +1 (883) 543-3337",
            "  name: Darla Sawyer",
            "- company: PASTURIA",
            "+ company: HaHARIA",
            "- isActive: false",
            "+ isActive: true",
            "- _id: 649aaa8a5f9b151acad0b0e0",
            "+ _id: 64999995f9b151acagasdgsdagd0b0e0",
            "  age: 37",
            "- email: darlasawyer@pasturia.com",
            "+ email: darlasadfsdg@ia.com",
            "+ favoriteFruit: banana",
            "+ address: 495 Chestnut Street, Caron, Tennessee, 1102",
            "+ greeting: Hello, Darla Sawyer! You have 4 unread messages.",
            "}"
        };
        assertThat(Differ.generate(file1, file2, "stylish")).contains(expected);
    }
}
