import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        locations locations = new locations();
        Charset charset = StandardCharsets.UTF_8;
        Path path = FileSystems.getDefault().getPath("./input_files/1/", "input");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                locations.parseLine(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        locations.sort_locations();
        System.out.println(locations.calculate_similarity());
    }
}