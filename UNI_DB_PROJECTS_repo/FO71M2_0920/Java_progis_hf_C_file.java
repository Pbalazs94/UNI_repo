
package main;

import java.util.List;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.util.Scanner;

public class FO71M2_NOV20_C
{
    static Scanner sc;
    
    static {
        FO71M2.sc = new Scanner(System.in);
    }
    
    public static void main(final String[] args) {
        final Path path = Paths.get("petro.txt", new String[0]);
        System.out.print("Adatok száma: ");
        final int count = Integer.parseInt(FO71M2.sc.next().toString());
        final List<String> ints = new ArrayList<String>();
        for (int i = 1; i < count + 1; ++i) {
            System.out.print(String.valueOf(i) + "-edik adat: ");
            ints.add(FO71M2.sc.next().toString());
        }
        try {
            Files.write(path, ints, new OpenOption[0]);
        }
        catch (IOException e) {
            System.out.println("No purchase!");
        }
        FO71M2.sc.close();
    }
}