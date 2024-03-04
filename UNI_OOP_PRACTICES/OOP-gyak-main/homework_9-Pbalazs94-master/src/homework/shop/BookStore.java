package homework.shop;

import java.util.ArrayList;

import java.util.Comparator;


import homework.bookhierachy.Book;
import homework.tax.Taxable;


public class BookStore {
	ArrayList<Book> stock = new ArrayList<Book>();
	ArrayList<Taxable> staff = new ArrayList<Taxable>();

	public ArrayList<Book> getStock() {
		return stock;
	}

	public ArrayList<Taxable> getStaff() {
		return staff;
	}

	public void addToStock(Book book) {
		stock.add((Book) book);
	}

	public void addToStaff(Employee employee) {
		staff.add((Employee) employee);
	}

	public int listStock() {
		int iterator = 0;
		for (int i = 0; i < stock.size(); i++) {
			iterator++;
		}
		return iterator;

	}

	public int listStaff() {
		int iterator = 0;
		for (int i = 0; i < staff.size(); i++) {
			iterator++;
		}
		return iterator;
	}

	public int sumVAT() {
		int sumVAT = 0;
		for (int i = 0; i < stock.size(); i++) {
			sumVAT = (int) (sumVAT + stock.get(i).getTax());
		}
		return sumVAT;
	}

	public int sumIncomTax() {
		int sumIncomeTax = 0;
		for (int i = 0; i < staff.size(); i++) {
			sumIncomeTax = (int) (sumIncomeTax + staff.get(i).getTax());;
		}
		return sumIncomeTax;
	}
	public class NameSorter implements Comparator<Book> {
		@Override
		public int compare(Book e1, Book e2) {
		return e1.getTitle().compareTo(e2.getTitle());
		}
		}
	

	public void sortByTitle() {
stock.sort( new NameSorter());

	}

	public void reverseSortByPrice() {
		Comparator<Book> compByPrice = Comparator.comparing(Book::getPrice);
		stock.sort(compByPrice.reversed());
	}
}
