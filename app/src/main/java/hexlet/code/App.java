package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
//import picocli.CommandLine.Command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.concurrent.Callable;
import java.util.Map;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.sql.SQLOutput;

@CommandLine.Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")


public class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", paramLabel = "format")
    private String format = "stylish";

    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private Path filepath1;

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private Path filepath2;

    @Override
    public Integer call() throws Exception {

        var data1 = getData(filepath1);
        var data2 = getData(filepath2);
        var comparisonResult = Differ.generate(data1, data2);
        System.out.println(comparisonResult);

        return 0;
    }

    public static Map getData(Path filepath) throws Exception {
        var path = "src/test/resources/" + filepath;
        var fullPath = Paths.get(path).toAbsolutePath().normalize();

        if (!Files.exists(fullPath)) {
            throw new Exception("File '" + fullPath + "' does not exist");
        }
        var content = Files.readString(fullPath);
        return Parser.parseJson(content);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}

