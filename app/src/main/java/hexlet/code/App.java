package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;
import java.util.concurrent.Callable;



@CommandLine.Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public final class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"},
            description = "output format [default: stylish]",
            defaultValue = "stylish",
            paramLabel = "format")

    private String format = "stylish";

    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private Path path1;

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private Path path2;

    @Override
    public Integer call() throws Exception {

        var filepath1 = path1 + "";
        var filepath2 = path2 + "";

        var diff = Differ.generate(filepath1, filepath2, format);
        System.out.println(diff);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    /* Здравствуй, Дорогой Мастер-Наставник! (здесь должно звучать спокойное фортепиано)
       Мне не передать все то, что испытала, выполняя данный проек!
       Он был по-настоящему непрост!

       Но я доползла до финала! И безумно горда собой :D
       Несмотря на стертые ладошечки, кровоточащие коленочки, стоптанные пяточки и прострелы в пояснице!

       Сейчас считаю все решения в проекте гениальными, ведь они сейчас кажутся единственноверными.
       К тому же, были обдумына и выстраданы в бесчетном колличестве часов!
       Используя предельные знания и ресурсы.

       Спасибо, Мастер, что приложишь "свою волшебную руку" к моему выстраданному проекту!
       Твое опытное мнение очень важно для меня. Заранее спасибо за совместную работу!
     */
}

