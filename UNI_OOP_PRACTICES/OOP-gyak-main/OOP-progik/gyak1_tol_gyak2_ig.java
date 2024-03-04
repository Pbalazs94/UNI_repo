package Java_forras;

public class gyak1_tol_gyak2_ig {
	static final double PI = 3.1415926535;
	public static void main(String[] args)
	{
		double[] numsLeibnitz = leibnitz(100);
		double[] numsWallis = wallis(100);
		printDifferenceFrom(numsLeibnitz, numsWallis);
	//printArray(nums);
	}
	
	static double[] leibnitz(int max)
	{
		double[] nums =new double[max];
		double current =1;
		for (int i=0; i<max;i++)
		{
			double addendum =1 / (double)(3+ i *2);
			if (i%2==0)
			{
				addendum *=-1;
			}
			current += addendum;
			nums[i] =current *4;
		}
		return nums;
	}
	
	static void printArray(double[] nums) 
	{
		for (double num : nums)
		{
			System.out.println(num);
		}
		for (double num :nums)
		{
			System.out.println(num);
		}
	}
	
 static double[] wallis(int max) {
	 double[] nums =new double[max];
	 double current =1;
	 double divisor =1, multiplier=1;
	 for (int i=0;i<max;i++)
	 {
		 current *=multiplier /divisor;
		 //felváltva növelje a számlálót és nevezőt
		 if(i%2==0)
		 {divisor +=2;
	 }
		 else
		 {
			 multiplier +=2;
		 }
		 nums[i]= current *2;
 }
	 return nums;
}
 static void printDifferenceFrom(double[] leib,double[] wal)
 {
	 for(int i=0;i< leib.length;i++)
	 {
		 double leibD =Math.abs( PI - leib[i]);
		 double walD =Math.abs( PI - wal[i]);
		 String closer = leibD > walD ? "wallis" : "leibnitz";
		 System.out.println(leibD + " - " + walD + " = " + closer);
	 }
 }
}
