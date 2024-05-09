package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    public void test1() throws Exception {
        var actual = Differ.generate("file1.json", "file2.json");
        var expected = "{\n"
                       + "  - follow: false\n"
                       + "    host: hexlet.io\n"
                       + "  - proxy: 123.234.53.22\n"
                       + "  - timeout: 50\n"
                       + "  + timeout: 20\n"
                       + "  + verbose: true\n"
                       + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        var actual = Differ.generate("file3.json", "file1.json");
        var expected = "{\n"
                + "  + follow: false\n"
                + "  + host: hexlet.io\n"
                + "  + proxy: 123.234.53.22\n"
                + "  + timeout: 50\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test3() throws Exception {
        var actual = Differ.generate("file1.json", "file3.json");
        var expected = "{\n"
                + "  - follow: false\n"
                + "  - host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test4() throws Exception {
        var actual = Differ.generate("file3.json", "file4.json");
        var expected = "{\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test5() throws Exception {
        var actual = Differ.generate("file1.yml", "file2.yml");
        var expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test6() throws Exception {
        var actual = Differ.generate("file31.json", "file32.json");

        var expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test7() throws Exception {
        var actual = Differ.generate("file31.yml", "file32.yml");

        var expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test8() throws Exception {
        var actual = Differ.generate("file31.json", "file32.json", "plain");

        var expected = "Property 'chars2' was updated. From [complex value] to false\n"
                     + "Property 'checked' was updated. From false to true\n"
                     + "Property 'default' was updated. From null to [complex value]\n"
                     + "Property 'id' was updated. From 45 to null\n"
                     + "Property 'key1' was removed\n"
                     + "Property 'key2' was added with value: 'value2'\n"
                     + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                     + "Property 'numbers3' was removed\n"
                     + "Property 'numbers4' was added with value: [complex value]\n"
                     + "Property 'obj1' was added with value: [complex value]\n"
                     + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                     + "Property 'setting2' was updated. From 200 to 300\n"
                     + "Property 'setting3' was updated. From true to 'none'";
        assertEquals(expected, actual);
    }

    @Test
    public void test9() throws Exception {
        var actual = Differ.generate("file31.yml", "file32.yml", "plain");

        var expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        assertEquals(expected, actual);
    }

    @Test
    public void test10() throws Exception {
        var actual = Differ.generate("file31.json", "file32.json", "json");

        var expected = "[ {\n"
                + "  \"type\" : \"unupdated\",\n"
                + "  \"value\" : [ \"a\", \"b\", \"c\" ],\n"
                + "  \"key\" : \"chars1\"\n"
                + "}, {\n"
                + "  \"value2\" : false,\n"
                + "  \"value1\" : [ \"d\", \"e\", \"f\" ],\n"
                + "  \"type\" : \"updated\",\n"
                + "  \"key\" : \"chars2\"\n"
                + "}, {\n"
                + "  \"value2\" : true,\n"
                + "  \"value1\" : false,\n"
                + "  \"type\" : \"updated\",\n"
                + "  \"key\" : \"checked\"\n"
                + "}, {\n"
                + "  \"value2\" : [ \"value1\", \"value2\" ],\n"
                + "  \"value1\" : null,\n"
                + "  \"type\" : \"updated\",\n"
                + "  \"key\" : \"default\"\n"
                + "}, {\n"
                + "  \"value2\" : null,\n"
                + "  \"value1\" : 45,\n"
                + "  \"type\" : \"updated\",\n"
                + "  \"key\" : \"id\"\n"
                + "}, {\n"
                + "  \"type\" : \"removed\",\n"
                + "  \"value\" : \"value1\",\n"
                + "  \"key\" : \"key1\"\n"
                + "}, {\n"
                + "  \"type\" : \"added\",\n"
                + "  \"value\" : \"value2\",\n"
                + "  \"key\" : \"key2\"\n"
                + "}, {\n"
                + "  \"type\" : \"unupdated\",\n"
                + "  \"value\" : [ 1, 2, 3, 4 ],\n"
                + "  \"key\" : \"numbers1\"\n"
                + "}, {\n"
                + "  \"value2\" : [ 22, 33, 44, 55 ],\n"
                + "  \"value1\" : [ 2, 3, 4, 5 ],\n"
                + "  \"type\" : \"updated\",\n"
                + "  \"key\" : \"numbers2\"\n"
                + "}, {\n"
                + "  \"type\" : \"removed\",\n"
                + "  \"value\" : [ 3, 4, 5 ],\n"
                + "  \"key\" : \"numbers3\"\n"
                + "}, {\n"
                + "  \"type\" : \"added\",\n"
                + "  \"value\" : [ 4, 5, 6 ],\n"
                + "  \"key\" : \"numbers4\"\n"
                + "}, {\n"
                + "  \"type\" : \"added\",\n"
                + "  \"value\" : {\n"
                + "    \"nestedKey\" : \"value\",\n"
                + "    \"isNested\" : true\n"
                + "  },\n"
                + "  \"key\" : \"obj1\"\n"
                + "}, {\n"
                + "  \"value2\" : \"Another value\",\n"
                + "  \"value1\" : \"Some value\",\n"
                + "  \"type\" : \"updated\",\n"
                + "  \"key\" : \"setting1\"\n"
                + "}, {\n"
                + "  \"value2\" : 300,\n"
                + "  \"value1\" : 200,\n"
                + "  \"type\" : \"updated\",\n"
                + "  \"key\" : \"setting2\"\n"
                + "}, {\n"
                + "  \"value2\" : \"none\",\n"
                + "  \"value1\" : true,\n"
                + "  \"type\" : \"updated\",\n"
                + "  \"key\" : \"setting3\"\n"
                + "} ]";
        assertEquals(expected, actual);
    }
}
