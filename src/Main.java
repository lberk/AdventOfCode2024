import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    private static void parse_line(String line, locations locations) {
        locations.parseLine(line);
    }

    public static void main(String[] args) {
        locations locations = new locations();
        Charset charset = StandardCharsets.UTF_8;
        Path path = FileSystems.getDefault().getPath(".", "input");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                parse_line(line, locations);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        Integer[] output_test = locations.getLocations(0);
        //System.out.printf("Total: %d, %d%n", output_test[0], output_test[1]);
        locations.sort_locations();
        int total = locations.calculate_distance();
        System.out.println(total);
    }
}