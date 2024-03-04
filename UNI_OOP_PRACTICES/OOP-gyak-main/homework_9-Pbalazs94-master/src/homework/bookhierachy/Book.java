package homework.bookhierachy;



import homework.tax.Taxable;

public class Book extends Product {
	// adattagok
	private String author;
	private String title;
	private final int yearOfPublication;
	private int price;
	private int pages;
	private String style;
	public double taxPercent = 5;
	static int number; //Ennél kell növelni 1 el a számot
	
	//Inner Nested class
	private static class Style {
		enum BookStyle {CHILDREN, GUIDE, CRIME, COOK, OTHER}
	}
	
	
	
	// konsturktrok
	public Book(String author, String title, int price, int pages, String style) {
		super("book", price);
		this.author = author;
		this.title = title;
		this.price = price;
		this.pages = pages;
		this.style = style;
		Style.BookStyle allBookStyles [] = Style.BookStyle.values();
		for( Style.BookStyle t : allBookStyles )
		{
			if(t.toString() == style) {
				this.style = style;
				break;
			}
			
			if((t.ordinal()==5) && (t.toString() != style))
			{
				style = "OTHER";
				break;
			}
		}
		
		number++;
		if (this.pages <= 0) {
			this.pages = 0;
		}
		if (this.price <= 0) {
			this.price = 0;
		}
		java.time.LocalDate currentDate = java.time.LocalDate.now();
		int year = currentDate.getYear(); // mai dátumból az év
		this.yearOfPublication = year;
	}
	

	public Book() {
		super("book", 0);
		java.time.LocalDate currentDate = java.time.LocalDate.now();
		int year = currentDate.getYear(); // mai dátumból az év
		this.yearOfPublication = year;
	}

	public Book(String author, String title, String style) {

		super("book", 0);

		this.author = author;
		this.title = title;
		
		Style.BookStyle allBookStyles [] = Style.BookStyle.values();
		for( Style.BookStyle t : allBookStyles )
		{
			if(t.toString() == style) {
				this.style = style;
				break;
			}
			
			if((t.ordinal()==5) && (t.toString() != style))
			{
				style = "OTHER";
				break;
			}
		}
		java.time.LocalDate currentDate = java.time.LocalDate.now(); // mai dátum
		int year = currentDate.getYear(); // mai dátumból az év
		this.yearOfPublication = year;
		setPages(100);
		getPages();
		price = 2500;
	}
//ToString() metódus	
	@Override
	public String toString() {
		return author + ": " + title + ", " + yearOfPublication + ". Price: " + price + " Ft" + " , pages:" + pages
				+ " , style:" + style + " Unit price:" + getUnitPrice();
	}

	
//Getterek és Setterek
	
	public float getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price >= 1000)
			this.price = price;
		else
			this.price = 1000;
	}
	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
	
		Style.BookStyle allBookStyles [] = Style.BookStyle.values();
		for( Style.BookStyle t : allBookStyles )
		{
			if(t.toString() == style) {
				this.style = style;
				break;
			}
			
			if((t.ordinal()==5) && (t.toString() != style))
			{
				style = "OTHER";
				break;
			}
		}
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

	public void setPages(int pages) {

		if (pages >= 0) {
			this.pages = pages;
		}
	}

	public int getPages() {
		return pages;
	}
	@Override
	public void setTax(double setTax) {
		if (setTax <= 0) {
			setTax = Taxable.taxPercent;
		}
		this.taxPercent = setTax;
	}
	public static int getNumber() {
		return number;
	}
	// @CsvSource({"10, 100", "0, 270", "-1, 270"})
	@Override
	public double getTax() {
		double result = 0;
		result = (price / 100) * taxPercent;
		return result;
	}

	public int getUnitPrice() {
		int result = -1;

		result = (int) (Math.round((getTaxedValue() / pages) * 100) / 100);
		return result;
	}

	
	
	//Metódusok
	public static String[] selectAuthors(Book[] books, int unitPrice) {
		String[] result = new String[books.length];
		int resultindex = -1;
		
		for (int i = 0; i < books.length; i++) {
			if ( books[i].getUnitPrice()> unitPrice) {
				String actual_author = books[i].author;
				boolean isAppeared = false;
				
				int j = i;
				do {
					if (j > 0) {
						j--;
						if (books[j].author.equals(actual_author)) {
							isAppeared = true;
						}

					}
				} while (j != 0);
				
				if (isAppeared == false) {
					System.out.println("actual author: "+actual_author);
					resultindex++;
					//for (int n = i + 1; n < books.length; n++) {
						//if (!books[n].author.equals(actual_author)) {
							System.out.println("FOR_IF bekerult author: "+books[i].author.toString());
							result[resultindex] = books[i].author;
						//}
					//}
					//System.out.println(authornumber);
				}				
			}
			
		}
		
		int authornumber = 0;
		for (int i=0; i< result.length;i++)
		{
			if (result[i] != null)
			{
				authornumber++;
			}
		}
		
		System.out.println("authornumber: " + authornumber);
		String [] authorsPricyBook = new String[authornumber];
		for (int i=0; i< authornumber;i++)
		{
			authorsPricyBook[i] = result[i];
		}
		
		return authorsPricyBook;		
	}

	public static int sumGrossPrice(Book[] books) {
		int sum = 0;

		for (int i = 0; i < books.length; i++) {
			sum = sum + books[i].getUnitPrice();
		}
		return sum;
	}

	

	// Mivel a yearOfPublication final, ezért ezt kikommenteztem
	// public void setYearOfPublication(int yearOfPublication) {
	// if (yearOfPublication >= 1950 && yearOfPublication <= 2021)
	// this.yearOfPublication = yearOfPublication;
	// else
	// this.yearOfPublication = 2021;
	// }

	


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

	public static Book getLonger(Book bookA, Book bookB) {

		if (bookA.pages >= bookB.pages) {
			return bookA;
		} else {
			return bookB;
		}
	}

	public boolean hasEvenPages() {
		if (this.pages % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void listBookArray(Book[] bookarray) {
		for (int i = 0; i < bookarray.length; i++) {
			System.out.print("Könyv szerzõje " + bookarray[i].author + "; könyv címe " + bookarray[i].title
					+ "; könyv ára " + bookarray[i].price + "; könyv oldalainak a száma " + bookarray[i].pages
					+ bookarray[i].style + "\n");
		}
	}

	public static Book getLongestEvenPagesBook(Book[] bookarray) {

		int i = 0;
		int maxbookpages = 0;
		int maxbookid = 0;
		for (i = 0; i < bookarray.length; i++) {
			if (bookarray[i].pages % 2 == 0) {
				if (maxbookpages < bookarray[i].pages) {
					maxbookpages = bookarray[i].pages;
					maxbookid = i;
				}
			}
		}
		i = maxbookid;
		if (bookarray[i].pages % 2 == 0) {
			return bookarray[i];
		} else
			return null;
	}

	public static Book getLongestBook(Book[] bookarray) {
		int i = 0;
		int maxbookpages = 0;
		int maxbookid = 0;
		for (i = 0; i < bookarray.length; i++) {

			if (maxbookpages < bookarray[i].pages) {
				maxbookpages = bookarray[i].pages;
				maxbookid = i;
			}
		}
		i = maxbookid;

		return bookarray[i];
	}

	public static void authorStatistics(Book[] bookarray) {
		for (int i = 0; i < bookarray.length; i++) {
			String actual_author = bookarray[i].author;
			boolean isAppeared = false;

			int j = i;
			do {
				if (j > 0) {
					j--;
					if (bookarray[j].author.equals(actual_author)) {
						isAppeared = true;
					}

				}
			} while (j != 0);

			if (isAppeared == false) {
				System.out.println(actual_author);
				int booknumber = 1;
				for (int n = i + 1; n < bookarray.length; n++) {
					if (bookarray[n].author.equals(actual_author)) {
						booknumber++;
					}
				}
				System.out.println(booknumber);
			}
		}
	}

	public static int countStyles(Book[] books) {
		String[] cstyle = new String[books.length];
		int maxcstyleindex = 0;
		for (int i = 0; i < books.length; i++) {
			if (i == 0) {
				cstyle[0] = books[i].style;
			}

			if (i > 0) {
				for (int j = 0; j < cstyle.length; j++) {
					if (cstyle[j] != null) {
						if (books[i].style.equalsIgnoreCase(cstyle[j]) == true) {
							break;
						} else {
							maxcstyleindex++;
							cstyle[maxcstyleindex] = books[i].style;

						}
					} else {
						break;
					}

				}
			}

		}
		return maxcstyleindex + 1;
	}

	public static void discountBooks(Book[] books, String stylereq) {

		for (int i = 0; i < books.length; i++) {
			if (books[i].style.equalsIgnoreCase(stylereq) == true) {
				books[i].price = books[i].price - Math.round(books[i].price * (float) 10 / 100);
			}
		}
	}

	public static int listBooksWithStyle(Book[] books, String style) {
		int cnt = 0;

		for (int i = 0; i < books.length; i++) {
			if (books[i].style.equalsIgnoreCase(style) == true) {
				cnt++;
			}
		}
		return cnt;
	}

	public static int avgPrice(Book[] books, String style) {
		int avgprice = 0;
		int sumprice = 0;
		int cnt = 0;

		for (int i = 0; i < books.length; i++) {
			if (books[i].style.equalsIgnoreCase(style) == true) {
				sumprice += books[i].price;
				cnt++;
			}
		}
		if (cnt > 0) {
			avgprice = sumprice / cnt;
			return Math.round(avgprice);
		} else {
			return avgprice = 0;
		}
	}

	@Override
	public void decreasePrice(int percent) {
		String Input1 = "children";
		String Input2 = "guide";
		if (this.style.equalsIgnoreCase(Input1) == true) {
			percent = percent + 7;
		}
		if (this.style.equalsIgnoreCase(Input2) == true) {
			percent = percent + 5;
		}
		price = price - Math.round(price * (float) percent / 100);

	}
	@Override
	protected void finalize()
	{
	number--;
	}
	
}
