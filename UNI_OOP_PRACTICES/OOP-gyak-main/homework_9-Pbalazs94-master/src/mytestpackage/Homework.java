package mytestpackage;

import java.util.Scanner;

import homework.bookhierachy.Book;
import homework.bookhierachy.EBook;


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
		//book.increasePrice(-10);
		// System.out.println(book.displayInfo());

		// Test with valid values
		// Mivel a yearOfPublication final, ez�rt ezt kikommenteztem
//		book.setYearOfPublication(2008);
		book.setPrice(3500);
		// System.out.println(book.displayInfo());
		//book.increasePrice(10);
		// System.out.println(book.displayInfo());

		//Book book1 = new Book("Csipke R�zsa", "Alv�s", 1998, 2000);
		//Book book2 = new Book("Vad�sz Pista", "National Geographic");

		//System.out.println(book1.toString());
		//System.out.println(book2.toString());
		// System.out.println( "K�nyv [�r�=" + book1.getAuthor() + ", c�m=" +
		// book1.getTitle() + ", kiad�s �ve=" + book1.getYearOfPublication() + ", �r="+
		// book1.getPrice() + "]");
		// System.out.println( "K�nyv [�r�=" + book2.getAuthor() + ", c�m=" +
		// book2.getTitle() + ", kiad�s �ve=" + book2.getYearOfPublication() + ", �r="+
		// book2.getPrice() + "]");
		//if (book1.getYearOfPublication() < book2.getYearOfPublication()) {
		//	System.out.println(book1.getAuthor() + "-nak a" + book1.getTitle() + " m�ve frissebb");
		//}
		//if (book1.getYearOfPublication() > book2.getYearOfPublication()) {
		//	System.out.println(book2.getAuthor() + "-nak a" + book2.getTitle() + " m�ve frissebb");
		//}
		// ---------------------------------------------------------------------------------

//n darab k�nyv beolvas�sa egy t�mbbe!
		System.out.println("Adja meg milyen term�ket szeretne beolvasni ! EBook vagy Book -ot");
		String Choose = new String();
		String EBOOK = new String();
		String BOOK = new String();
		BOOK ="Book";
		EBOOK="EBook";
		Choose = input.nextLine();
		if(Choose.equalsIgnoreCase(BOOK) == true) {
		int booknumber = readInt();

		Book bookarray[];
		bookarray = new Book[booknumber];
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
			
			bookarray[i] = new Book(author, title, price, pages, style);

		}
		
		Book.listBookArray(bookarray);
		
		System.out.println("\n Leghosszabb k�nyv: " +Book.getLongestBook(bookarray));
		System.out.println("\n Leghosszabb p�ros oldalsz�m� k�nyv: " + Book.getLongestEvenPagesBook(bookarray));
		Book.authorStatistics(bookarray);
		
		System.out.println("\n St�lusok sz�ma: " + Book.countStyles(bookarray));
		
		Book.selectAuthors(bookarray, 2000);
		
		
		
		}
		if (Choose.equalsIgnoreCase(EBOOK) == true)
		{
			int Ebooknumber = readInt();
			
			EBook Ebookarray[];
			Ebookarray = new EBook[Ebooknumber];
			for (int i = 0; i < Ebookarray.length; i++) {

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
				
				
				System.out.println("K�rlek add meg a k�nyv e-c�m�t!");
				input.nextLine();
				String url = input.nextLine();
				//System.out.println(style + " a k�nyv e-c�me!");
				
				Ebookarray[i] = new EBook(author, title, price, pages, style, url);

			}
			EBook.listBookArray(Ebookarray);
			
			System.out.println("\n Leghosszabb k�nyv: " +EBook.getLongestBook(Ebookarray));
			System.out.println("\n Leghosszabb p�ros oldalsz�m� k�nyv: " + EBook.getLongestEvenPagesBook(Ebookarray));
			EBook.authorStatistics(Ebookarray);
			
			System.out.println("\n St�lusok sz�ma: " + EBook.countStyles(Ebookarray));
			EBook.countStyles(Ebookarray);
			EBook.discountBooks(Ebookarray, "Horror");
			EBook.listBooksWithStyle(Ebookarray, "Horror");
			EBook.avgPrice(Ebookarray, "Horror");
			
			
		}
		
		System.out.println("K�rlek add meg az E-k�nyvek sz�m�t!");
		int Ebooknumber = readInt();
		
		EBook Ebookarray[];
		Ebookarray = new EBook[Ebooknumber];
		for (int i = 0; i < Ebookarray.length; i++) {

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
			
			
			System.out.println("K�rlek add meg a k�nyv e-c�m�t!");
			input.nextLine();
			String url = input.nextLine();
			//System.out.println(style + " a k�nyv e-c�me!");
			
			Ebookarray[i] = new EBook(author, title, price, pages, style, url);
		}
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
