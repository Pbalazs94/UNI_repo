package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class FO71M2_NOV20_E
{

	public static void main(String[] args) 
	{
		
		Auto[] cars = {new Auto("R11", "Opel", 333),
					   new Auto("R12", "Fiat", 233),
					   new Auto("R13", "Skoda", 364)};
		
		List<Auto> carlist = new ArrayList<Auto>();
		for (Auto car : cars) carlist.add(car);
		
		try 
		{
			FileOutputStream writeData = new FileOutputStream("outputFO71M2.ser");
			ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
			
			 writeStream.writeObject(carlist);
			 writeStream.flush();
			 writeStream.close();
		} catch (IOException e) 
		{
			System.out.println("nincs kimenet");
		}
	}

}