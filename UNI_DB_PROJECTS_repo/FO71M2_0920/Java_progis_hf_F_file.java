package main;

public class Auto 
{
	String rsz;
	String tipus;
	int ar;
	
	public Auto(String rsz, String tipus, int ar)
	{
		this.rsz = rsz;
		this.tipus = tipus;
		this.ar = ar;
	}
	
	@Override
	public String toString()
	{
		return rsz + " " + tipus + " " +ar;
	}
}