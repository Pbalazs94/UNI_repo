package Java_forras;
import java.util.Scanner;
public class gyak_3_hf2 {
//gyak 2 diából az 5 ös feladat Sztring nevek es email cimek + hany 1 nel tobb email cimmel rendelkezo szemely van

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Hany szemely adatat akarja felvenni (1-5) ?");
        int person = read(1, 5);
        String[] names = new String[person];
        String[][] emails = new String[person][];
        readEmails(names, emails);
        printEmails(names, emails);
    }

    public static int read(int min, int max) {
        int number = 0;
        do {
            System.out.println("Adj egy szamot a min : " + min + " es a max: " + max + "kozott !");
            while (!input.hasNextInt()) {
                System.out.println("Hibas input!");
                input.next();
            }
            number = input.nextInt();
            input.nextLine();
        } while (number < min || number > max);
        return number;
    }

    public static void readEmails(String[] names, String[][] emails) {
        int sum=0;
    	for (int i = 0; i < names.length; i++) {
            System.out.print("Nev: ");
            names[i] = input.nextLine();
            System.out.println("Mennyi Email cime van " + names[i] + " -nak/nek? (0-3)");
            int addresses = read(0, 3);
            if (addresses>1)
            {
            	sum++;
            }
            emails[i] = new String[addresses];
            for (int address = 0; address < addresses; address++) {
                System.out.println("Email #" + (address + 1) + ":");
                emails[i][address] = input.nextLine();
                
            }
            
        }
    	System.out.println("Ennyi embernek van 1 nel tobb email cime: " + sum);
    }

    public static void printEmails(String[] names, String[][] emails) {
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + ": ");
            for (int address = 0; address < emails[i].length; address++) {
                System.out.print(emails[i][address] + " ");
            }
            System.out.println();
        }
    }
}

