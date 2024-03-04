package Java_forras;


	
	//Gyak 3 as diából az 1. feladat (kalkulátor)

import java.util.Scanner;

public class FO71M2_02_24_hf1 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            double a = 0;
            double b = 0;
            String op = new String();
            boolean ok;
            do {
                ok = true;
                System.out.println("A Kalkulator programban elvegezheto a negy alap muvelet (Szorzas,Osztas,Kivonas,Osszeadas)");
                System.out.println("Adja meg milyen muveletet kivan elvegezni! ");
                System.out.println("Adja meg A erteket, az operatort, es B erteket + koztuk legyen szunet!");
                String equation = input.nextLine();
                String[] split = equation.split(" ");
                try {
                    a = Double.parseDouble(split[0]);
                    b = Double.parseDouble(split[2]);
                    op = split[1];
                } catch (Exception e) {
                    ok = false;
                    System.out.println("Hibas input!");
                }
                if (op.equals("/") && b == 0) {
                    System.out.println("0-val valo osztas!");
                    ok = false;
                }
            } while (!ok);
            System.out.format("%f %s %f = %f%n", a, op, b, calc(a, b, op));
        } while (keepRunning());
        System.out.println("Muveletek elvegezve! Ha ujabb muveletet kivan vegezni inditsa ujra a programot!");
    }

    public static boolean keepRunning() {
        System.out.println("Akar meg muveletet elvegezni? (igen/nem)");
        if (input.nextLine().equals("igen")) {
            return true;
        } else {
            return false;
        }
    }

    public static double calc(double a, double b, String op) {
        double result;
        switch (op) {
        case "+":
            result = a + b;
            break;
        case "-":
            result = a - b;
            break;
        case "*":
            result = a * b;
            break;
        case "/":
            result = a / b;
            break;
        default:
            throw new IllegalArgumentException("Nem megfelelo operator: " + op);
        }
        return result;
    }
}