package homework.tax;

public interface Taxable {
public int taxPercent = 27;

abstract public void setTax(double setTax);
abstract public double getTax();
abstract public double getTaxedValue();
}
