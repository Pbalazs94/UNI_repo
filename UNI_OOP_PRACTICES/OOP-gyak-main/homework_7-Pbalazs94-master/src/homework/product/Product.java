package homework.product;

public class Product {
	private String name;
	private int price;

	
	public Product (String name,int price) {
		this.name=name;
		if (price >= 0) {
			this.price = price;
		}
		
	}
	@Override
	public String toString() {
		return "Name: " + name + " and " + ". Price: " + price + " Ft" ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
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
	public void decreasePrice(int percent)
	{
		
			price =price -Math.round(price * (float)percent/100);
		
		
	}
}
