package homework.product;

import homework.tax.Taxable;

public class Product implements Taxable {
	private String name;
	private float price;
	private int taxPercent;
	protected String currency = "Ft";

	@Override
	public void setTax(double setTax) {
		if (setTax <= 0) {
			setTax = Taxable.taxPercent;
		}
	}

	@Override
	public double getTax() {
		double result=0;
		result= (price/100)	*taxPercent;
		return result;
	}

	@Override
	public double getTaxedValue() {
		double result=0;
		result= (price+getTax());
		return result;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {

		String input = currency;

		if (input.equals("Euro"))
				{
					price = price / 300;
					this.currency = input;
				}
		if (input.equals("Ft"))
		{
			price = price * 300;
			this.currency = input;
		}
				
		

		if (input == "Ft" || input == "Euro") {

			if (this.currency != input) {
				if (input == "Euro") {
					price = price / 300;
					this.currency = input;
				}
				if (input == "Ft") {
					price = price * 300;
					this.currency = input;
				}
			}
		} 
		else {
			if (!input.equals("Euro") && !input.equals("Ft")) {
				if (input.equals("Euro"))
				{
					price = price / 300;
				}
			this.currency = "Ft";
		}

	}
	}
	public static void changeCurrency(Product[] products, String targetCurrency)
	{
		for (int i =0;i<products.length;i++)
		{
			if (products[i].currency != targetCurrency)
			{
				products[i].setCurrency(targetCurrency);
				products[i].price = Math.round(products[i].price* 100) / 100;
			}
		}
	}

	public static int comparePrice(Product p1, Product p2) {
		int result = -1;
		if (p1.getPrice() == p2.getPrice()) {
			result = 0;
		}
		else if (p1.getPrice() > p2.getPrice()) {
			result = 1;
		} 
		else{
			result = 2;
		}
		return result;
	}

	abstract class getUnitPrice {
		abstract public int getUnitPrice();
	}

	public Product(String name, int price, int taxPercent) {
		this.name = name;
		this.price = price;
		this.taxPercent = taxPercent;

		if (this.price <= 0) {
			this.price = 0;
		}
		if (this.taxPercent <= 0) {
			this.taxPercent = Taxable.taxPercent;
		}
	}

	public Product(String name, int price) {
		this.name = name;
		if (price >= 0) {
			this.price = price;
		}

	}

	@Override
	public String toString() {
		return "Name: " + name + " and " + ". Price: " + price + " Ft" + " Brutto: " + getTaxedValue() ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		}

	}

	public void increasePrice(int percentage) {
		if (percentage > 0) {
			price += Math.round(price * (float) percentage / 100);
		}
	}

	public void decreasePrice(int percent) {

		price = price - Math.round(price * (float) percent / 100);

	}
}
