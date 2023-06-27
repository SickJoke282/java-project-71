package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checksum 4.7.4",
        description = "Compares two configuration files and shows a difference.")
class App {
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
