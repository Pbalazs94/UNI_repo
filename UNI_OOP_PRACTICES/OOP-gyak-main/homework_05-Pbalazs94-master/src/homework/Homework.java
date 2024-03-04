package homework;

public class Homework {
	
	public static void main(String[] args)  {
		
		Book book = new Book();
		book.setAuthor("J.K. Rowling");
		book.setTitle("Harry Potter");
		
		// Test with invalid values
		book.setYearOfPublication(2025);
		book.setPrice(0);
		System.out.println(book.displayInfo());
		book.increasePrice(-10);
		System.out.println(book.displayInfo());
		
		// Test with valid values
		book.setYearOfPublication(2008);
		book.setPrice(3500);
		System.out.println(book.displayInfo());
		book.increasePrice(10);
		System.out.println(book.displayInfo());

		Book book1 = new Book("Csipke Rózsa", "Alvás", 1998, 2000);
		Book book2 = new Book("Vadász Pista", "National Geographic");
		
		System.out.println(book1.toString());
		System.out.println(book2.toString());
			//System.out.println( "Könyv [Író=" + book1.getAuthor() + ", cím=" + book1.getTitle() + ", kiadás éve=" + book1.getYearOfPublication() + ", ár="+ book1.getPrice() + "]");
			//System.out.println( "Könyv [Író=" + book2.getAuthor() + ", cím=" + book2.getTitle() + ", kiadás éve=" + book2.getYearOfPublication() + ", ár="+ book2.getPrice() + "]");
		if(	book1.getYearOfPublication() < book2.getYearOfPublication())
		{
			System.out.println(book1.getAuthor() + "-nak a" + book1.getTitle() + " mûve frissebb");
		}
		if(	book1.getYearOfPublication() > book2.getYearOfPublication())
		{
			System.out.println(book2.getAuthor() + "-nak a" + book2.getTitle() + " mûve frissebb");
		}
		}
	}


