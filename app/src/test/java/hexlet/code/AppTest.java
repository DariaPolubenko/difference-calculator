package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    public void test1() throws Exception {

        var data1 = App.getData("src/test/resources/file1.json");
        var data2 = App.getData("src/test/resources/file2.json");

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

        var data1 = App.getData("src/test/resources/file21.json");
        var data2 = App.getData("src/test/resources/file22.json");

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

        var data1 = App.getData("src/test/resources/file3.json"); //пустой
        var data2 = App.getData("src/test/resources/file21.json");

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

        var data1 = App.getData("src/test/resources/file21.json");
        var data2 = App.getData("src/test/resources/file3.json"); //пустой

        var actual = Differ.generate(data1, data2);
        var expected = "{\n"
                + "  - Возраст: 25\n"
                + "  - Город: Сочи\n"
                + "  - Имя: Иван\n"
                + "  - Фамилия: Ужиков\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test5() throws Exception {

        var data1 = App.getData("src/test/resources/file3.json"); //пустой
        var data2 = App.getData("src/test/resources/file4.json"); //пустой

        var actual = Differ.generate(data1, data2);
        var expected = "{\n"
                + "}";
        assertEquals(expected, actual);
    }

    @Test
    public void test6() throws Exception {

        var data1 = App.getData("src/test/resources/file1.yml");
        var data2 = App.getData("src/test/resources/file2.yml");

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
}
