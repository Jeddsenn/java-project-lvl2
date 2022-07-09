package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.nio.file.Path;
import java.util.concurrent.Callable;

import static hexlet.code.Differ.generate;
import static hexlet.code.Parser.parseJsonToMap;


@Command (
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        version = "0.0.8"
)


public class App implements Callable<Integer> {
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean usageHelpRequest;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean versionInfoRequest;
    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format", paramLabel = "format")
    private String format;
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private Path filepath1;

    public Path getFilepath1() {
        return filepath1;
    }

    public Path getFilepath2() {
        return filepath2;
    }

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private Path filepath2;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CommandLine commandLine = new CommandLine(new App());
        commandLine.execute(args);
    }

    @Override
    public Integer call() throws Exception {


        System.out.println(generate(parseJsonToMap(String.valueOf(filepath1)), parseJsonToMap(String.valueOf(filepath2))));
        return 0;
    }
}
