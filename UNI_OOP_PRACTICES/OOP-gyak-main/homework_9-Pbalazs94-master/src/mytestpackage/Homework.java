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
		// Mivel a yearOfPublication final, ezért ezt kikommenteztem
//		book.setYearOfPublication(2025);
		book.setPrice(0);
		// System.out.println(book.displayInfo());
		//book.increasePrice(-10);
		// System.out.println(book.displayInfo());

		// Test with valid values
		// Mivel a yearOfPublication final, ezért ezt kikommenteztem
//		book.setYearOfPublication(2008);
		book.setPrice(3500);
		// System.out.println(book.displayInfo());
		//book.increasePrice(10);
		// System.out.println(book.displayInfo());

		//Book book1 = new Book("Csipke Rózsa", "Alvás", 1998, 2000);
		//Book book2 = new Book("Vadász Pista", "National Geographic");

		//System.out.println(book1.toString());
		//System.out.println(book2.toString());
		// System.out.println( "Könyv [Író=" + book1.getAuthor() + ", cím=" +
		// book1.getTitle() + ", kiadás éve=" + book1.getYearOfPublication() + ", ár="+
		// book1.getPrice() + "]");
		// System.out.println( "Könyv [Író=" + book2.getAuthor() + ", cím=" +
		// book2.getTitle() + ", kiadás éve=" + book2.getYearOfPublication() + ", ár="+
		// book2.getPrice() + "]");
		//if (book1.getYearOfPublication() < book2.getYearOfPublication()) {
		//	System.out.println(book1.getAuthor() + "-nak a" + book1.getTitle() + " mûve frissebb");
		//}
		//if (book1.getYearOfPublication() > book2.getYearOfPublication()) {
		//	System.out.println(book2.getAuthor() + "-nak a" + book2.getTitle() + " mûve frissebb");
		//}
		// ---------------------------------------------------------------------------------

//n darab könyv beolvasása egy tömbbe!
		System.out.println("Adja meg milyen terméket szeretne beolvasni ! EBook vagy Book -ot");
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
			
			bookarray[i] = new Book(author, title, price, pages, style);

		}
		
		Book.listBookArray(bookarray);
		
		System.out.println("\n Leghosszabb könyv: " +Book.getLongestBook(bookarray));
		System.out.println("\n Leghosszabb páros oldalszámú könyv: " + Book.getLongestEvenPagesBook(bookarray));
		Book.authorStatistics(bookarray);
		
		System.out.println("\n Stílusok száma: " + Book.countStyles(bookarray));
		
		Book.selectAuthors(bookarray, 2000);
		
		
		
		}
		if (Choose.equalsIgnoreCase(EBOOK) == true)
		{
			int Ebooknumber = readInt();
			
			EBook Ebookarray[];
			Ebookarray = new EBook[Ebooknumber];
			for (int i = 0; i < Ebookarray.length; i++) {

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
				
				
				System.out.println("Kérlek add meg a könyv e-címét!");
				input.nextLine();
				String url = input.nextLine();
				//System.out.println(style + " a könyv e-címe!");
				
				Ebookarray[i] = new EBook(author, title, price, pages, style, url);

			}
			EBook.listBookArray(Ebookarray);
			
			System.out.println("\n Leghosszabb könyv: " +EBook.getLongestBook(Ebookarray));
			System.out.println("\n Leghosszabb páros oldalszámú könyv: " + EBook.getLongestEvenPagesBook(Ebookarray));
			EBook.authorStatistics(Ebookarray);
			
			System.out.println("\n Stílusok száma: " + EBook.countStyles(Ebookarray));
			EBook.countStyles(Ebookarray);
			EBook.discountBooks(Ebookarray, "Horror");
			EBook.listBooksWithStyle(Ebookarray, "Horror");
			EBook.avgPrice(Ebookarray, "Horror");
			
			
		}
		
		System.out.println("Kérlek add meg az E-könyvek számát!");
		int Ebooknumber = readInt();
		
		EBook Ebookarray[];
		Ebookarray = new EBook[Ebooknumber];
		for (int i = 0; i < Ebookarray.length; i++) {

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
			
			
			System.out.println("Kérlek add meg a könyv e-címét!");
			input.nextLine();
			String url = input.nextLine();
			//System.out.println(style + " a könyv e-címe!");
			
			Ebookarray[i] = new EBook(author, title, price, pages, style, url);
		}
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
