package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

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
    private String filepath1;

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;

    @Override
    public Integer call() throws Exception {
        var diff = Differ.generate(filepath1, filepath2, format);
        System.out.println(diff);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
    /* Здравствуй, Дорогой Наставник!
    Насладившись победой готова работать засучив рукава ***

    Спасибо большое за все твои комментарии к проекту, время и силы!
    Это очень помогает мне понять устройство хорошего кода.
    Что в свою очередь влияет на веру в себя и качество последующих проектов :)))
     */
