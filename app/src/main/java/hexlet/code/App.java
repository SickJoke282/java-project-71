package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checksum 4.7.4",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to the first file")
    private File file1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to the second file")
    private File file2;

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            defaultValue = "stylish", description = "output format ${DEFAULT-VALUE}")
    private String formatter;

    @Override
    public Integer call() throws Exception {
        String diff = Differ.generate(file1, file2, formatter);
        System.out.println(diff);
        return 0;
    }
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
