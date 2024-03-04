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

		Book book1 = new Book("Csipke R�zsa", "Alv�s", 1998, 2000);
		Book book2 = new Book("Vad�sz Pista", "National Geographic");
		
		System.out.println(book1.toString());
		System.out.println(book2.toString());
			//System.out.println( "K�nyv [�r�=" + book1.getAuthor() + ", c�m=" + book1.getTitle() + ", kiad�s �ve=" + book1.getYearOfPublication() + ", �r="+ book1.getPrice() + "]");
			//System.out.println( "K�nyv [�r�=" + book2.getAuthor() + ", c�m=" + book2.getTitle() + ", kiad�s �ve=" + book2.getYearOfPublication() + ", �r="+ book2.getPrice() + "]");
		if(	book1.getYearOfPublication() < book2.getYearOfPublication())
		{
			System.out.println(book1.getAuthor() + "-nak a" + book1.getTitle() + " m�ve frissebb");
		}
		if(	book1.getYearOfPublication() > book2.getYearOfPublication())
		{
			System.out.println(book2.getAuthor() + "-nak a" + book2.getTitle() + " m�ve frissebb");
		}
		}
	}


