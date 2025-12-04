package gr.aueb.cf.playground;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtils {

    public static boolean fileExists(Path path){
        return Files.exists(path);
    }

    public static void writeLine(Path path, String input) throws IOException {
        Files.writeString(path, input + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static List<String> readLines(Path path) throws IOException{
        return Files.readAllLines(path);
    }

    public static void writeLines (Path path, List<String> lines) throws IOException{
        for (String line: lines){
            writeLine(path, line);
        }
    }
}
