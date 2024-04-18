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
    private File filepath1;

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private File filepath2;

    @Override
    public Integer call() throws Exception {

        //Path filePath1 = Paths.get("src/test/resources/file1.json").toAbsolutePath().normalize();
        //Path filePath2 = Paths.get("src/test/resources/file2.json").toAbsolutePath().normalize();

        var filePath1 = Paths.get(filepath1).toAbsolutePath().normalize();
        var filePath2 = Paths.get(filepath2).toAbsolutePath().normalize();

        var contentOfFile1 = Files.readString(filePath1);
        var contentOfFile2 = Files.readString(filePath2);

        var parseContent1 = parseJson(contentOfFile1);
        var parseContent2 = parseJson(contentOfFile2);

        var comparisonResult = Differ.generate(parseContent1, parseContent2);
        System.out.println(comparisonResult);

        System.out.println(parseContent1);
        System.out.println(parseContent2);

        return 0;
    }

    public static Map parseJson(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}

