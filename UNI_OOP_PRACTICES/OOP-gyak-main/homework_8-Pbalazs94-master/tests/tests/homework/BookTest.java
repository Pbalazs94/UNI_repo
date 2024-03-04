package tests.homework;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import homework.Book;
import homework.EBook;


public class BookTest{
	
	protected static final String author = "J.K. Rowling";
	protected static final String title = "Harry Potter";
	protected static final int yearOfPub = 2008;
	protected static final int price = 3500;
	protected static final int pages = 111;
	protected static final String style = "guide";
	
	protected Book createValidBook() {
		return new Book(author, title, price, pages, style);
	}
		
	@Test
	@DisplayName("A 4 paraméteres konstruktornak a publikáció évét a jelen évre kell állítania!")
	public void _4ParamConstructor_ShouldSetyearOfPublicationToCurrentYear()
	{
		Book book = createValidBook();
		java.time.LocalDate currentDate = java.time.LocalDate.now();
		assertEquals(currentDate.getYear(), book.getYearOfPublication());
	}
	
	@Test
	@DisplayName("A 2 paraméteres konstruktornak 2500-ra kell állítania az árat!")
	public void _2ParamConstructor_ShouldSetPriceTo2500()
	{
		Book book = new Book(author, title, style);
		assertEquals(2500, book.getPrice());
	}
	
	@Test
	@DisplayName("A 2 paraméteres konstruktornak 100-ra kell állítania az oldalszámot!")
	public void _2ParamConstructor_ShouldSetPagesTo100()
	{
		Book book = new Book(author, title, style);
		assertEquals(100, book.getPages());
	}
	
	@ParameterizedTest
	@CsvSource({"1000,1000", "0,0", "-1000,0"})
	@DisplayName("A 4 paraméteres konstruktornak az árat a megadott pozitív értékre kell állítania, vagy 0-ra, ha az nem pozitív!")
	public void _4ParamConstructor_ShouldSetPriceToGivenPositiveValueOr0Otherwise(int setPrice, int expectedPrice)
	{
		Book book = new Book(author, title, setPrice, pages, style);

		assertEquals(expectedPrice, book.getPrice());
	}
	
	@ParameterizedTest
	@CsvSource({"1000,1000", "0,0", "-1000,0"})
	@DisplayName("A 4 paraméteres konstruktornak az oldalszámot a megadott pozitív értékre kell állítania, vagy 0-ra, ha az nem pozitív!")
	public void _4ParamConstructor_ShouldSetPagesToGivenPositiveValueOr0Otherwise(int setPages, int expectedPages)
	{
		Book book = new Book(author, title, price, setPages, style);

		assertEquals(expectedPages, book.getPages());
	}
	
	@Test
	@DisplayName("Az toString kimenetének tartalmaznia kell a címet")
	public void toString_ResultShouldContainTitle()
	{
		Book book = createValidBook();
		String result = book.toString();
		assertTrue(result.contains(title),
				"A toString által elõállított string nem tartalmazza a címet!");
	}
	
	@Test
	@DisplayName("Az toString kimenetének tartalmaznia kell a szerzõt")
	public void toString_ResultShouldContainAuthor()
	{
		Book book = createValidBook();
		String result = book.toString();
		assertTrue(result.contains(author),
				"A toString által elõállított string nem tartalmazza az árat!");
	}
	
	@Test
	@DisplayName("Az toString kimenetének tartalmaznia kell a publikáció évét")
	public void toString_ResultShouldContainYearOfPublication()
	{
		Book book = createValidBook();
		String result = book.toString();
		java.time.LocalDate currentDate = java.time.LocalDate.now();
		assertTrue(result.contains(Integer.toString(currentDate.getYear())),
				"A toString által elõállított string nem tartalmazza a publikáció évét!");
	}
	
	@Test
	@DisplayName("Az toString kimenetének tartalmaznia kell az árat")
	public void toString_ResultShouldContainPrice()
	{
		Book book = createValidBook();
		String result = book.toString();
		assertTrue(result.contains(Integer.toString(price)),
				"A toString által elõállított string nem tartalmazza az árat!");
	}
	
	@Test
	@DisplayName("Az toString kimenetének tartalmaznia kell az oldalszámot")
	public void toString_ResultShouldContainPages()
	{
		Book book = createValidBook();
		String result = book.toString();
		assertTrue(result.contains(Integer.toString(pages)),
				"A toString által elõállított string nem tartalmazza az oldalszámot!");
	}

	@Test
	@DisplayName("Az toString kimenetének tartalmaznia kell a stílust")
	public void toString_ResultShouldContainStyle()
	{
		Book book = createValidBook();
		String result = book.toString();
		assertTrue(result.contains(style),
				"A toString által elõállított string nem tartalmazza a stílust!");
	}

	@ParameterizedTest
	@CsvSource({"100,-1", "100,-123", "100,-456753"})
	@DisplayName("A setPages negatív bemenetre nem szabad,hogy változtassa a pages értékét!")
	public void setPages_ForNegativeValues_ShouldNotChangePages(int startPages, int setPages)
	{
		Book book = new Book(author, title, price, startPages, style);
		book.setPages(setPages);

		assertEquals(startPages, book.getPages());
	}
	
	@ParameterizedTest
	@CsvSource({"1104,938", "1107, 941"})
	@DisplayName("A Book descreasePrice-nak tört eredmény esetén kerekítenie kell a matematikai szabályoknak megfelelõen!")
	public void decreasePrice_FractionalResult_ShouldBeRoundedAccordingToRules(int originalPrice, int expectedPrice)
	{
		Book book = createValidBook();
		book.setPrice(originalPrice);
		book.setStyle(style);
		book.decreasePrice(10);
		assertEquals(expectedPrice, book.getPrice());
	}

	
	@Test
	@DisplayName("A getLonger az elsõ könyvet adja vissza azonos oldalszám esetén!")
	public void getLonger_ForEqualPages_ShouldReturnFirstBook()
	{
		Book bookA = new Book(author, title, price, 1234, style);
		Book bookB = new Book(author, title, price, 1234, style);

		Book longer = Book.getLonger(bookA, bookB);
		
		assertEquals(longer, bookA);
	}
	
	@ParameterizedTest
	@CsvSource({"1,2,1", "2,1,0"})
	@DisplayName("A getLonger a nagyobb oldalszámmal rendelkezõ könyvet adja vissza a 2 paraméter közül!")
	public void getLonger_ForDifferingPages_ShouldReturnTheLongerBook(int bookAPages, int bookBPages, int longerIndex)
	{
		Book[] books = {new Book(author, title, price, bookAPages, style),
				new Book(author, title, price, bookBPages, style)};

		Book longer = Book.getLonger(books[0], books[1]);
		
		assertEquals(longer, books[longerIndex]);
	}
	
	@ParameterizedTest
	@CsvSource({"1, false", "2, true", "333, false", "444, true"})
	@DisplayName("A hasEvenPages igazat ad vissza, ha páros a pages, hamisat ellenkezõ esetben!")
	public void hasEvenPages_ShouldReturnTrueIfPagesIsEvenFalseOtherwise(int pages, boolean isEven)
	{
		Book book = new Book(author, title, price, pages, style);

		assertEquals(isEven, book.hasEvenPages());
	}
	
	@ParameterizedTest
	@CsvSource({"1, 2, 3, 3", "3, 2, 1, 3", "2, 3, 1, 3", "2, 1, 3, 3"})
	@DisplayName("A getLongestBook visszaadja a leghosszabb könyvet!")
	public void getLongestBook_ShouldReturnTheBookWithTheMostPages(int pagesA, int pagesB,
			int pagesC, int longestPages)
	{
		Book[] books = {new Book(author, title, price, pagesA, style),
				new Book(author, title, price, pagesB, style),
				new Book(author, title, price, pagesC, style)};
		
		Book longest = Book.getLongestBook(books);
		
		assertEquals(longestPages, longest.getPages());
	}
	
	@ParameterizedTest
	@CsvSource({"1, 2, 4, 5, 4", "4, 2, 1, 5, 4", "5, 4, 2, 1, 4", "2, 1, 5, 4, 4"})
	@DisplayName("A getLongestEvenPagesBook visszaadja a leghosszabb páros oldalszámú könyvet!")
	public void getLongestEvenPagesBook_ShouldReturnTheBookWithTheMostEvenPages(int pagesA, int pagesB,
			int pagesC, int pagesD, int longestPages) {
		Book[] books = {new Book(author, title, price, pagesA, style),
				new Book(author, title, price, pagesB, style),
				new Book(author, title, price, pagesC, style),
				new Book(author, title, price, pagesD, style)};
		
		Book longest = Book.getLongestEvenPagesBook(books);
		
		assertEquals(longestPages, longest.getPages());
	}
	
	@ParameterizedTest
	@CsvSource({"1, 3, 5, 7"})
	@DisplayName("A getLongestEvenPagesBook visszaadja a leghosszabb páros oldalszámú könyvet!")
	public void getLongestEvenPagesBook_ForArraysWithNoEvenPageBooks_ShouldReturnNull(int pagesA, int pagesB,
			int pagesC, int pagesD)
	{
		Book[] books = {new Book(author, title, price, pagesA, style),
				new Book(author, title, price, pagesB, style),
				new Book(author, title, price, pagesC, style),
				new Book(author, title, price, pagesD, style)};
		
		Book longest = Book.getLongestEvenPagesBook(books);
		
		assertNull(longest);
	}
	
	@Test
	@DisplayName("A countStyles a különbözõ stílusok számát adja vissza!")
	public void countStylesTest()
	{
		Book[] books = {
				new Book(author, title, price, 1, "guide"),
				new Book(author, title, price, 1, "guide"),
				new Book(author, title, price, 1, "scifi")
		};
		int expectecNumberOfStyles = 2;
		
		assertEquals(expectecNumberOfStyles, Book.countStyles(books));
	}
	
	@Test
	@DisplayName("A discountBooks csak az adott stílusú könyvek árát csökkenti!")
	public void discountBooksTest()
	{
		Book[] books = {
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "scifi")
		};
		int expectedPriceHorror = 1800;
		int expectedPriceScifi = 2000;
		Book.discountBooks(books, "horror");		
		assertEquals(expectedPriceHorror, books[0].getPrice());
		assertEquals(expectedPriceHorror, books[1].getPrice());
		assertEquals(expectedPriceScifi, books[2].getPrice());
	}

	@Test
	@DisplayName("A listBooksWithStyle csak az adott stílusú könyveket listázza!")
	public void listBooksWithStyleTest()
	{
		Book[] books = {
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "scifi")
		};
		int expectedSizeOfList = 2;
		assertEquals(expectedSizeOfList, Book.listBooksWithStyle(books, "horror"));
	}
	
	@Test
	@DisplayName("Az avgPrice csak az adott stílusú könyvek átlagárát adja vissza!")
	public void avgPriceWitExistingStyle()
	{
		Book[] books = {
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "scifi")
		};
		int expectedAvg = 2000;
		assertEquals(expectedAvg, Book.avgPrice(books, "horror"));
	}

	@Test
	@DisplayName("Az avgPrice 0-át ad vissza, ha nincs adott stílusú könyv!")
	public void avgPriceWitNonExistingStyle()
	{
		Book[] books = {
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "scifi")
		};
		int expectedAvg = 0;
		assertEquals(expectedAvg, Book.avgPrice(books, "guide"));
	}
	
	//8. hét
	
	//Mivel a Product abstract csak innen tudjuk közvetetten tesztelni néhány tulajdonságát
	
	@ParameterizedTest
	@CsvSource({"10, 100", "0, 270", "-1, 270"})
	@DisplayName("A beállított adó mértéke csak pozitív szám lehet!")
	public void setTax_ShouldOnlySetPositiveValues(int setTax, int expectedTax)
	{
		Book book = createValidBook();
		book.setPrice(1000);
		book.setTax(setTax);
		
		assertEquals(expectedTax, book.getTax());
	}
	
	@Test
	@DisplayName("A pénznem alapértelmezett értéke Ft legyen!")
	public void currency_ShouldBeFt_ByDefault()
	{
		Book book = createValidBook();
		assertEquals("Ft", book.getCurrency());
	}
	
	@ParameterizedTest
	@CsvSource({"Ft, Ft", "Euro, Euro", "USD, Ft"})
	@DisplayName("A devizanem csak Ft, vagy Euro lehet! Más megadott érték esetén legyen Ft!")
	public void setCurrency_ShouldOnlySetFtOrEuro(String setCurrency, String expectedCurrency)
	{
		Book book = createValidBook();
		book.setCurrency(setCurrency);
		
		assertEquals(expectedCurrency, book.getCurrency());
	}

	
	@Test
	@DisplayName("Az toString kimenetének tartalmaznia kell az egységárat!")
	public void toString_ResultShouldContainUnitPrice()
	{
		Book book = createValidBook();
		String result = book.toString();
		//A Double.toString ott hagyja mögötte a .0-t és eltér a konkatenált változattól
		assertTrue(result.contains("" + book.getUnitPrice()),
				"A toString által elõállított string nem tartalmazza az bruttó árat!");
	}
	
	@Test
	@DisplayName("Az avgPrice 0-át ad vissza, ha nincs adott stílusú könyv!")
	public void getUnitPrice_ShouldReturnTaxedValue()
	{
		Book[] books = {
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "horror"),
				new Book(author, title, 2000, 1, "scifi")
		};
		int expectedAvg = 0;
		assertEquals(expectedAvg, Book.avgPrice(books, "guide"));
	}
	
	@Test
	@DisplayName("A selectAuthors visszaadja az összes szerzõt, akinek van a megadott egységárnál drágább könyve a tömbben!")
	public void selectAuthors_ShouldReturnAllAuthorsWhoHaveBooksAboveTheGivenUnitPrice()
	{
		Book[] books = {
				new Book("A", "a1", 2100, 1, "horror"),
				new Book("A", "a2", 1900, 1, "horror"),
				new Book("A", "a3", 2200, 1, "scifi"),
				new Book("B", "b", 2300, 1, "scifi"),
				new Book("C", "c", 1900, 1, "scifi"),
				new Book("D", "d", 1800, 1, "scifi"),
		};
		
		String[] authors = Book.selectAuthors(books, 2000);
		
		assertEquals(2, authors.length);
		
		Arrays.sort(authors);
		
		assertTrue(Arrays.binarySearch(authors, "A") >= 0);
		assertTrue(Arrays.binarySearch(authors, "B") >= 0);
	}
	
	@Test
	@DisplayName("A sumGrossPrice kiszámítja egy Book tömbben a könyvek adóval növelt összárát!")
	public void sumGrossPrice_ShouldReturnTheSumOfGrossPricesOfTheBooksInTheArray()
	{
		Book[] books = {
				new Book("A", "a1", 1000, 1, "horror"),
				new Book("A", "a2", 2000, 1, "horror"),
				new Book("A", "a3", 4000, 1, "scifi"),
		};
		
		books[1].setTax(10.0);
		books[2].setTax(25.0);
		
		assertEquals(8250, Book.sumGrossPrice(books));
	}
}