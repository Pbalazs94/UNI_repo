package main;

public class Task1 {
	
	static final double PI = 3.1415926535;

	public static void main(String[] args) {
		double[] numsLeibnitz = leibnitz(100);
		double[] numsWallis = wallis(100);
		printDifferenceFrom(numsLeibnitz, numsWallis);
	}
	
	static double[] leibnitz(int max) {
		double[] nums = new double[max];
		double current = 1;
		for (int i = 0; i < max; i++) {
			double addendum = 1 / (double)(3 + i * 2);
			if (i % 2 == 0) {
				addendum *= -1;
			}
			current += addendum;
			nums[i] = current * 4;
		}
		return nums;
	}
	
	// 2 / 1 
	static double[] wallis(int max) {
		double[] nums = new double[max];
		double current = 1;
		double divisor = 1, multiplier = 2;
		for (int i = 0; i < max; i++) {
			current *= multiplier / divisor;
			if (i % 2 == 0) {
				divisor += 2;
			} else {
				multiplier += 2;
			}
			nums[i] = current * 2;
		}
		return nums;
	}
	
	static void printDifferenceFrom(double[] leib, double[] wal) {
		for (int i = 0; i < leib.length; i++) {
			double leibD = Math.abs(PI - leib[i]);
			double walD = Math.abs(PI - wal[i]);
			String closer =  leibD > walD ? "wallis" : "leibnitz";
			System.out.println(leibD + " - " + walD + " = " + closer);
		}
	}
	
	static void printArray(double[] nums) {
		for (double num : nums) {
			num += 1;
		}
		for (double num : nums) {
			System.out.println(num);
		}
	}

}
