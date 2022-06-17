package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command (
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        version = "0.0.1"
)


public class App {
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean usageHelpRequest;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean versionInfoRequest;
    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format", paramLabel = "format")
    private String format;
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String f0;
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String f1;






    public static void main(String[] args) {
        System.out.println("Hello World!");
        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);
        commandLine.execute(args);

    }
}

