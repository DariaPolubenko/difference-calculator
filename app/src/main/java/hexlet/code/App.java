package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

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
        //byte[] fileContents = Files.readAllBytes(filepath1.toPath());
        //byte[] digest = MessageDigest.getInstance(format).digest(fileContents);
        //System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));

        System.out.println("Hello, World!");
        return 0;
    }
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
