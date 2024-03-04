package homework;

import java.util.Scanner;

public class Homework {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Book book = new Book();
		book.setAuthor("J.K. Rowling");
		book.setTitle("Harry Potter");

		// Test with invalid values
		// Mivel a yearOfPublication final, ez�rt ezt kikommenteztem
//		book.setYearOfPublication(2025);
		book.setPrice(0);
		// System.out.println(book.displayInfo());
		book.increasePrice(-10);
		// System.out.println(book.displayInfo());

		// Test with valid values
		// Mivel a yearOfPublication final, ez�rt ezt kikommenteztem
//		book.setYearOfPublication(2008);
		book.setPrice(3500);
		// System.out.println(book.displayInfo());
		book.increasePrice(10);
		// System.out.println(book.displayInfo());

		Book book1 = new Book("Csipke R�zsa", "Alv�s", 1998, 2000);
		Book book2 = new Book("Vad�sz Pista", "National Geographic");

		System.out.println(book1.toString());
		System.out.println(book2.toString());
		// System.out.println( "K�nyv [�r�=" + book1.getAuthor() + ", c�m=" +
		// book1.getTitle() + ", kiad�s �ve=" + book1.getYearOfPublication() + ", �r="+
		// book1.getPrice() + "]");
		// System.out.println( "K�nyv [�r�=" + book2.getAuthor() + ", c�m=" +
		// book2.getTitle() + ", kiad�s �ve=" + book2.getYearOfPublication() + ", �r="+
		// book2.getPrice() + "]");
		if (book1.getYearOfPublication() < book2.getYearOfPublication()) {
			System.out.println(book1.getAuthor() + "-nak a" + book1.getTitle() + " m�ve frissebb");
		}
		if (book1.getYearOfPublication() > book2.getYearOfPublication()) {
			System.out.println(book2.getAuthor() + "-nak a" + book2.getTitle() + " m�ve frissebb");
		}
		// ---------------------------------------------------------------------------------

//n darab k�nyv beolvas�sa egy t�mbbe!		
		int booknumber = readInt();

		Book bookarray[];
		bookarray = new Book[booknumber];
		for (int i = 0; i < bookarray.length; i++) {
			String author;
			String title;
			int price;
			int pages;

			input.nextLine();
			System.out.println("K�rlek add meg a k�nyv szerz�j�t!");
			author = input.nextLine();
			System.out.println(author + " a k�nyv szerz�je!");

			System.out.println("K�rlek add meg a k�nyv c�m�t!");
			title = input.nextLine();
			System.out.println(title + " a k�nyv c�me!");

			System.out.println("K�rlek add meg a k�nyv �r�t!");
			price = input.nextInt();
			System.out.println(price + " a k�nyv �ra!");

			System.out.println("K�rlek add meg a k�nyv oldaainak sz�m�t!");
			pages = input.nextInt();
			System.out.println(pages + " a k�nyv oldalak sz�ma!");

			bookarray[i] = new Book(author, title, price, pages);

		}

		Book.listBookArray(bookarray);
		
		System.out.println("\n Leghosszabb k�ny: " +Book.getLongestBook(bookarray));
		System.out.println("\n Leghosszabb p�ros oldalsz�m� k�nyv: " + Book.getLongestEvenPagesBook(bookarray));
		Book.authorStatistics(bookarray);
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
