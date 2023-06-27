package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;


import org.junit.jupiter.api.Test;

class DifferTest {

    @Test
    void testTake() throws Exception {
        File file1 = new File("./src/test/resources/file1.json");
        File file2 = new File("./src/test/resources/file2.json");
        String[] expected = {
                "{",
                 "- proxy: 123.234.53.22",
                 "  host: hexlet.io",
                 "- follow: false",
                 "- timeout: 50",
                 "+ timeout: 20",
                 "+ verbose: true",
                "}"
                };
        assertThat(Differ.generate(file1, file2)).contains(expected);
    }

    @Test
    void testTake2() throws Exception {
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
        assertThat(Differ.generate(file1, file2)).contains(expected);
    }
}