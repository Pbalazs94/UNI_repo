package homework;

import java.util.Scanner;

public class Homework {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Book book = new Book();
		book.setAuthor("J.K. Rowling");
		book.setTitle("Harry Potter");

		// Test with invalid values
		// Mivel a yearOfPublication final, ezért ezt kikommenteztem
//		book.setYearOfPublication(2025);
		book.setPrice(0);
		// System.out.println(book.displayInfo());
		book.increasePrice(-10);
		// System.out.println(book.displayInfo());

		// Test with valid values
		// Mivel a yearOfPublication final, ezért ezt kikommenteztem
//		book.setYearOfPublication(2008);
		book.setPrice(3500);
		// System.out.println(book.displayInfo());
		book.increasePrice(10);
		// System.out.println(book.displayInfo());

		Book book1 = new Book("Csipke Rózsa", "Alvás", 1998, 2000);
		Book book2 = new Book("Vadász Pista", "National Geographic");

		System.out.println(book1.toString());
		System.out.println(book2.toString());
		// System.out.println( "Könyv [Író=" + book1.getAuthor() + ", cím=" +
		// book1.getTitle() + ", kiadás éve=" + book1.getYearOfPublication() + ", ár="+
		// book1.getPrice() + "]");
		// System.out.println( "Könyv [Író=" + book2.getAuthor() + ", cím=" +
		// book2.getTitle() + ", kiadás éve=" + book2.getYearOfPublication() + ", ár="+
		// book2.getPrice() + "]");
		if (book1.getYearOfPublication() < book2.getYearOfPublication()) {
			System.out.println(book1.getAuthor() + "-nak a" + book1.getTitle() + " mûve frissebb");
		}
		if (book1.getYearOfPublication() > book2.getYearOfPublication()) {
			System.out.println(book2.getAuthor() + "-nak a" + book2.getTitle() + " mûve frissebb");
		}
		// ---------------------------------------------------------------------------------

//n darab könyv beolvasása egy tömbbe!		
		int booknumber = readInt();

		Book bookarray[];
		bookarray = new Book[booknumber];
		for (int i = 0; i < bookarray.length; i++) {
			String author;
			String title;
			int price;
			int pages;

			input.nextLine();
			System.out.println("Kérlek add meg a könyv szerzõjét!");
			author = input.nextLine();
			System.out.println(author + " a könyv szerzõje!");

			System.out.println("Kérlek add meg a könyv címét!");
			title = input.nextLine();
			System.out.println(title + " a könyv címe!");

			System.out.println("Kérlek add meg a könyv árát!");
			price = input.nextInt();
			System.out.println(price + " a könyv ára!");

			System.out.println("Kérlek add meg a könyv oldaainak számát!");
			pages = input.nextInt();
			System.out.println(pages + " a könyv oldalak száma!");

			bookarray[i] = new Book(author, title, price, pages);

		}

		Book.listBookArray(bookarray);
		
		System.out.println("\n Leghosszabb köny: " +Book.getLongestBook(bookarray));
		System.out.println("\n Leghosszabb páros oldalszámú könyv: " + Book.getLongestEvenPagesBook(bookarray));
		Book.authorStatistics(bookarray);
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
