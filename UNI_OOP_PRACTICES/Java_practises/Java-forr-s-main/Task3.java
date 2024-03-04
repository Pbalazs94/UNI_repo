package teszt_package;

public class Task3 {
	
	static void main(String[] args)
	{
		int[] arr =new int[10];
		for (int i=0;i<arr.length;i++)
		{
			arr[i] =(int) Math.random()* 100;
		}
		//printArrayWrite(arr[10]);
		
		for (int i=0;i<10;i++)
		{
			System.out.println(arr);
		}
		for (int i=10;i>0;i--)
		{
			System.out.println(arr);
		}
		double average = 0;
		double sum =0;
		int k=0;
		for (int i=0;i<10;i++)
		{
			if (arr[i] %2 ==0)
			{
				sum += arr[i];
				 k++;
			}
			average = sum /k;
			System.out.println(average);
		}
	}
	
	/*
	 * Gyak1 ből a 3. task/feladat első 3 része
	 * 
	 * Otthon minimum keresés és tegyük fel  Gitre
	 * */
	static void printArrayWrite(double[] nums)
{
		for (int i=0;i<10;i++)
		{
			System.out.println(nums);
		}
}
	static void printArrayWriteBackwards(double[] nums)
{
		for (int i=10;i>0;i--)
		{
			System.out.println(nums);
		}
}
	static void ParosNumAvgWrite(double[] nums)
	{
		double average = 0;
		double sum =0;
		int k=0;
		for (int i=0;i<10;i++)
		{
			if (nums[i] %2 ==0)
			{
				sum += nums[i];
				 k++;
			}
			average = sum /k;
			System.out.println(average);
		}
	}
}
