package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command (
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        version = "0.1.0"
)


public final class App implements Callable<Integer> {
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean usageHelpRequest;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean versionInfoRequest;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish",
            description = "the file to use (default: ${DEFAULT-VALUE})", paramLabel = "format")
    private String format;

    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;


    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new App());
        commandLine.execute(args);
    }

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println(Differ.generate(filepath1, filepath2, format));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 1;
        }
        return 0;
    }
}
