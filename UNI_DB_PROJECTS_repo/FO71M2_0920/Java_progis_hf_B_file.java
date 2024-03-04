
package main;

import java.nio.file.Path;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FO71M2_NOV20_B
{
    static Scanner sc;
    
    static {
        FO71M2.sc = new Scanner(System.in);
    }
    
    public static void main(final String[] args) {
        String line = "";
        final List<String> lines = new ArrayList<String>();
        while (!line.contains("end")) {
            line = FO71M2.sc.next().toString();
            lines.add(line);
        }
        final Path path = Paths.get(String.valueOf(lines.get(0)) + "petro.txt", new String[0]);
        lines.remove(0);
        try {
            Files.write(path, lines, new OpenOption[0]);
        }
        catch (IOException e) {
            System.out.println("network");
        }
        List<String> biglines = null;
        try {
            biglines = Files.readAllLines(path, StandardCharsets.UTF_8);
        }
        catch (IOException e2) {
            System.out.println("network 2");
        }
        biglines.stream().forEach(k -> System.out.println(k.toUpperCase()));
    }
}