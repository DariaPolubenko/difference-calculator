package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import java.util.Map;
import java.math.BigInteger;
import java.security.MessageDigest;


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

        System.out.println(data1);
        System.out.println(data2);


        Map comparisonResult = Differ.generate(data1, data2);

        System.out.println(comparisonResult);

        return 0;
    }

    public static Map getData(Path filepath) throws Exception {
        var fullPath = filepath.toAbsolutePath().normalize();

        if (!Files.exists(fullPath)) {
            throw new Exception("File '" + fullPath + "' does not exist");
        }
        var content = Files.readString(fullPath);

        System.out.println("строка " + content);
        return Parser.parseJson(content);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}

