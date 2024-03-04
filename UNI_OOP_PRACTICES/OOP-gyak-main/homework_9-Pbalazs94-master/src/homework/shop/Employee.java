package homework.shop;

import homework.tax.Taxable;


public class Employee implements Taxable {

@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", getTax()=" + getTax() + "]";
	}
private String name;
private int salary;
private int SZJA_kulcs=15;

public Employee (String name, int salary)
{
	this.name = name;
	this.salary =salary;
}
public String getName() {
	return name;
}
public int getSalary() {
	return salary;
}
public int getSZJA_kulcs() {
	return SZJA_kulcs;
}
@Override
public void setTax(double setTax) {
	// TODO Auto-generated method stub
	setTax=15;
}
@Override
public double getTax() {
	double SZJsum = salary * SZJA_kulcs / 100;
	return SZJsum;
}
@Override
public double getTaxedValue() {

	double SZJsalary;
	SZJsalary = salary-getTax();
	return SZJsalary;
}


}
