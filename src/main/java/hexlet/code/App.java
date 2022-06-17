package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;



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


    public static void main(String[] args) {
        System.out.println("Hello World!");
        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);
        commandLine.execute(args);

    }
}
