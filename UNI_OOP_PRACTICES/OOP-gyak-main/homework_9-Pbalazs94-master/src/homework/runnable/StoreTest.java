package homework.runnable;

import java.util.Scanner;


import homework.shop.BookStore;


public class StoreTest {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
BookStore bookstore = new BookStore();

/*
 * - p�ld�nyos�t egy BookStore objektumot
	- ezt felt�lti n�h�ny k�nyvvel �s alkalmazottal
	- kilist�zza a rakt�ron lev� k�nyveket
	- rendezi ABC szerint a k�nyveket, majd ism�t kilist�zza
	- rendezi �r szerint a k�nyveket, majd ism�t kilist�zza
	- ki�rja az �sszes�tett �FA-t �s SZJA-t.
 * */
System.out.println("Adj meg egy szamot annyi konyvet hozzunk letre! \n");
int booknumber = readInt();

BookStore bookarray[];
bookarray = new BookStore[booknumber];
for (int i = 0; i < bookarray.length; i++) {

	input.nextLine();
	
	System.out.println("K�rlek add meg a k�nyv szerz�j�t!");
	String author = input.nextLine();
	//System.out.println(author + " a k�nyv szerz�je!");

	System.out.println("K�rlek add meg a k�nyv c�m�t!");
	String title = input.nextLine();
	//System.out.println(title + " a k�nyv c�me!");

	System.out.println("K�rlek add meg a k�nyv �r�t!");
	int price = input.nextInt();
	//System.out.println(price + " a k�nyv �ra!");

	System.out.println("K�rlek add meg a k�nyv oldalainak sz�m�t!");
	int pages = input.nextInt();
	//System.out.println(pages + " a k�nyv oldalak sz�ma!");
	
	System.out.println("K�rlek add meg a k�nyv st�lus�t!");
	input.nextLine();
	String style = input.nextLine();			
	//System.out.println(style + " a k�nyv st�lusa!");
	
	 
	 bookarray[i] = new BookStore();

}

bookstore.listStaff();
bookstore.listStock();
bookstore.sortByTitle();
System.out.println(bookstore);
bookstore.reverseSortByPrice();
System.out.println(bookstore);
System.out.println(bookstore.sumIncomTax());
System.out.println(bookstore.sumVAT());

	}

public static int readInt() {
	int n = 0;
	do {
		System.out.println("Adja meg a k�nyvek darabsz�m�t " + 1 + " �s " + 10 + " k�z�tt!");
		while (!input.hasNextInt()) {
			System.out.println("Csak 1 �s 10 k�z�tti eg�sz sz�m lehet!");
			input.next();
		}
		n = input.nextInt();
	} while (n < 1 || n > 10);
	return n;
}

}


