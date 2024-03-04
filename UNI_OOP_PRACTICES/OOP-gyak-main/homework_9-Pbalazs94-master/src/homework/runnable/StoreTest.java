package homework.runnable;

import java.util.Scanner;


import homework.shop.BookStore;


public class StoreTest {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
BookStore bookstore = new BookStore();

/*
 * - példányosít egy BookStore objektumot
	- ezt feltölti néhány könyvvel és alkalmazottal
	- kilistázza a raktáron levõ könyveket
	- rendezi ABC szerint a könyveket, majd ismét kilistázza
	- rendezi ár szerint a könyveket, majd ismét kilistázza
	- kiírja az összesített ÁFA-t és SZJA-t.
 * */
System.out.println("Adj meg egy szamot annyi konyvet hozzunk letre! \n");
int booknumber = readInt();

BookStore bookarray[];
bookarray = new BookStore[booknumber];
for (int i = 0; i < bookarray.length; i++) {

	input.nextLine();
	
	System.out.println("Kérlek add meg a könyv szerzõjét!");
	String author = input.nextLine();
	//System.out.println(author + " a könyv szerzõje!");

	System.out.println("Kérlek add meg a könyv címét!");
	String title = input.nextLine();
	//System.out.println(title + " a könyv címe!");

	System.out.println("Kérlek add meg a könyv árát!");
	int price = input.nextInt();
	//System.out.println(price + " a könyv ára!");

	System.out.println("Kérlek add meg a könyv oldalainak számát!");
	int pages = input.nextInt();
	//System.out.println(pages + " a könyv oldalak száma!");
	
	System.out.println("Kérlek add meg a könyv stílusát!");
	input.nextLine();
	String style = input.nextLine();			
	//System.out.println(style + " a könyv stílusa!");
	
	 
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
		System.out.println("Adja meg a könyvek darabszámát " + 1 + " és " + 10 + " között!");
		while (!input.hasNextInt()) {
			System.out.println("Csak 1 és 10 közötti egész szám lehet!");
			input.next();
		}
		n = input.nextInt();
	} while (n < 1 || n > 10);
	return n;
}

}


