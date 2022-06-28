package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.concurrent.Callable;

import static hexlet.code.Differ.genPath;


@Command (
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        version = "0.0.1"
)


public class App implements Callable<Integer> {
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean usageHelpRequest;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean versionInfoRequest;
    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format", paramLabel = "format")
    private String format;
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);
        commandLine.execute(args);
    }

    @Override
    public Integer call() throws Exception {

        String fileFirstJson = genPath(filepath1);
        String fileSecondJson = genPath(filepath2);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapFirst = mapper.readValue(fileFirstJson, new TypeReference<>() {
        });
        Map<String, Object> mapSecond = mapper.readValue(fileSecondJson, new TypeReference<>() {
        });
        System.out.println(new Differ().generate(mapFirst, mapSecond));
        return 0;
    }
}
