
package main;

import java.util.List;
import java.nio.file.Path;
import java.nio.file.OpenOption;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.nio.file.Paths;

public class FO71M2_NOV20_A
{
    public static void main(final String[] args) {
        final Path infile = Paths.get("inputFO71M2.txt", new String[0]);
        final Path outfile = Paths.get("outputFO71M2.txt", new String[0]);
        final String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(infile, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            System.out.println("\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1\u00c1");
        }
        String combo = "";
        final List<String> stringlines = new ArrayList<String>();
        for (int i = 0; i < lines.size(); ++i) {
            String[] ints = lines.get(i).split("");
            for (int k = 0; k < ints.length; ++k) {
                combo = String.valueOf(combo) + numbers[Integer.parseInt(ints[k])] + " ";
            }
            stringlines.add(combo);
            combo = "";
            ints = null;
        }
        try {
            Files.write(outfile, stringlines, new OpenOption[0]);
        }
        catch (IOException e2) {
            System.out.println("nincs kimenet");
        }
    }
}