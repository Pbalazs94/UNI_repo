package main;

import java.io.IOException;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class FO71M2_NOV20_D
{
    public static void main(final String[] args) throws IOException {
        final Path path = Paths.get("petro.txt", new String[0]);
        final List<String> allof = Files.readAllLines(path, StandardCharsets.UTF_8);
        int sum = 0;
        System.out.println("Elemek száma: " + allof.size());
        for (int i = 0; i < allof.size(); ++i) {
            System.out.println(String.valueOf(i + 1) + "-edik elem: " + allof.get(i));
            sum += Integer.parseInt(allof.get(i));
        }
        System.out.println("Az elemek összege: " + sum);
    }
}