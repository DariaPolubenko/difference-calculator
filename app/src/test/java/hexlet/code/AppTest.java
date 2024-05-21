package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

class AppTest {
    @Test
    public void test1() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json");
        var expected = readFixture("stylish1.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        var actual = Differ.generate("src/test/resources/file31.yml", "src/test/resources/file32.yml");
        var expected = readFixture("stylish2.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test3() throws Exception {
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "stylish");
        var expected = readFixture("stylish1.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test4() throws Exception {
        var actual = Differ.generate("src/test/resources/file31.yml", "src/test/resources/file32.yml", "stylish");
        var expected = readFixture("stylish2.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test5() throws Exception {
        var actual = Differ.generate("src/test/resources/file31.json", "src/test/resources/file32.json", "plain");
        var expected = readFixture("plain.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test6() throws Exception {
        var actual = Differ.generate("src/test/resources/file31.yml", "src/test/resources/file32.yml", "plain");
        var expected = readFixture("plain.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test7() throws Exception {
        var actual = Differ.generate("src/test/resources/file31.json", "src/test/resources/file32.json", "json");
        var expected = readFixture("json.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test8() throws Exception {
        var actual = Differ.generate("src/test/resources/file31.yml", "src/test/resources/file32.yml", "json");
        var expected = readFixture("json.txt");
        assertEquals(expected, actual);
    }

    public static String readFixture(String filepath) throws Exception {
        var fullPath = Paths.get("src/test/resources/fixtures/" + filepath).toAbsolutePath().normalize();

        if (!Files.exists(fullPath)) {
            throw new Exception("File '" + fullPath + "' does not exist");
        }

        var content = Files.readString(fullPath);
        return content;
    }
}
