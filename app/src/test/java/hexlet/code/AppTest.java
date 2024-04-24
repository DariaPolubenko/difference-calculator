package hexlet.code;

import static hexlet.code.App.getData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

class AppTest {
    @Test
    public void test1() throws Exception {

        Path filepath1 = Paths.get("file1.json");
        Path filepath2 = Paths.get("file2.json");

        var data1 = getData("src/test/resources/" + filepath1);
        var data2 = getData("src/test/resources/" + filepath2);

        var actual = Differ.generate(data1, data2);
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

        Path filepath1 = Paths.get("file21.json");
        Path filepath2 = Paths.get("file22.json");

        var data1 = getData("src/test/resources/" + filepath1);
        var data2 = getData("src/test/resources/" + filepath2);

        var actual = Differ.generate(data1, data2);
        var expected = "{\n"
                + "  - Возраст: 25\n"
                + "  - Город: Сочи\n"
                + "  - Имя: Иван\n"
                + "  + Имя: Илья\n"
                + "  + Образование: НГТУ\n"
                + "    Фамилия: Ужиков\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test3() throws Exception {

        Path filepath1 = Paths.get("file3.json");
        Path filepath2 = Paths.get("file21.json");

        var data1 = getData("src/test/resources/" + filepath1);
        var data2 = getData("src/test/resources/" + filepath2);

        var actual = Differ.generate(data1, data2);
        var expected = "{\n"
                + "  + Возраст: 25\n"
                + "  + Город: Сочи\n"
                + "  + Имя: Иван\n"
                + "  + Фамилия: Ужиков\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test4() throws Exception {

        Path filepath1 = Paths.get("file3.json"); //пустой
        Path filepath2 = Paths.get("file21.json");

        var data1 = getData("src/test/resources/" + filepath1);
        var data2 = getData("src/test/resources/" + filepath2);

        var actual = Differ.generate(data1, data2);
        var expected = "{\n"
                + "  + Возраст: 25\n"
                + "  + Город: Сочи\n"
                + "  + Имя: Иван\n"
                + "  + Фамилия: Ужиков\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test5() throws Exception {

        Path filepath1 = Paths.get("file21.json");
        Path filepath2 = Paths.get("file3.json"); //пустой

        var data1 = getData("src/test/resources/" + filepath1);
        var data2 = getData("src/test/resources/" + filepath2);

        var actual = Differ.generate(data1, data2);
        var expected = "{\n"
                + "  - Возраст: 25\n"
                + "  - Город: Сочи\n"
                + "  - Имя: Иван\n"
                + "  - Фамилия: Ужиков\n"
                + "}";
        assertEquals(expected, actual);
    }
}
