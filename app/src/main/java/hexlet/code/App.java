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

        var absolutePath1 = filepath1.toAbsolutePath().normalize();
        var absolutePath2 = filepath2.toAbsolutePath().normalize();

        var content1 = Files.readString(absolutePath1);
        var content2 = Files.readString(absolutePath2);

        var parseContent1 = parseJson(content1);
        var parseContent2 = parseJson(content2);

        var comparisonResult = Differ.generate(parseContent1, parseContent2);

        System.out.println(comparisonResult);

        return 0;
    }

    public static Map parseJson(String content) throws Exception {
        ObjectMapper parseContent = new ObjectMapper();
        return parseContent.readValue(content, Map.class);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}

