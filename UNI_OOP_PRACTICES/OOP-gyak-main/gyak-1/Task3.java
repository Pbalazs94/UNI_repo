package main;

public class Task3 {
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100);
		}
		print(numbers);
        printReversed(numbers);
        int avg = avgEvenNumbers(numbers);
        System.out.println("Average: " + avg);
        int minValue = minValue(numbers);
        int minIndex = minIndex(numbers);
        System.out.println("Min Value: " + minValue + " Min Index: " + minIndex + " Min index value: " + numbers[minIndex]);
        selectionSortIncreasing(numbers);
        System.out.println("Sorted array:");
        print(numbers);
	}

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print('\n');
    }

    public static void printReversed(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.print('\n');
    }

    public static int avgEvenNumbers(int arr[]) {
        int avg = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] % 2) == 0) {
                cnt++;
                avg += arr[i];
            }
        }
        avg /= cnt;
        return avg;
    }

    public static int minValue(int arr[]) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int minIndex(int arr[]) {
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    public static void selectionSortIncreasing(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

}