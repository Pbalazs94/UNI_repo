package homework;

public class Book {
	private String author;
	private String title;
	private int yearOfPublication;
	private int price;

	public Book(String author, String title, int yearOfPub, int price) {
		this.author = author;
		this.title = title;
		this.yearOfPublication = yearOfPub;
		this.price = price;
	}
	public Book() {
		
	}
	public Book(String author, String title) {
		this.author = author;
		this.title = title;
		java.time.LocalDate currentDate = java.time.LocalDate.now(); // mai dátum
		int year = currentDate.getYear(); // mai dátumból az év
		this.yearOfPublication = year;
		price = 2500;
	}

	public void increasePrice(int percentage) {
		if (percentage > 0) {
			price += Math.round(price * (float) percentage / 100);
		}
	}

	public String displayInfo() {
		return author + ": " + title + ", " + yearOfPublication + ". Price: " + price + " Ft";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		if (yearOfPublication >= 1950 && yearOfPublication <= 2021)
			this.yearOfPublication = yearOfPublication;
		else
			this.yearOfPublication = 2021;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price >= 1000)
			this.price = price;
		else
			this.price = 1000;
	}

	@Override
	public String toString() {
		return author + ": " + title + ", " + yearOfPublication + ". Price: " + price + " Ft";
	}

	public static int comparePublicationDate(Book yearOfPubA, Book yearOfPubB) {

		int result = -1;
		if (yearOfPubA.yearOfPublication == yearOfPubB.yearOfPublication) {
			result = 0;

		} else if (yearOfPubA.yearOfPublication > yearOfPubB.yearOfPublication) {
			result = 1;
		} else if (yearOfPubA.yearOfPublication < yearOfPubB.yearOfPublication) {
			result = 2;

		}
		return result;
	}

}
