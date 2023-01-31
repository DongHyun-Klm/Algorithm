import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			if (min>arr[i]) min = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			if (max<arr[i]) max = arr[i];
		}
		System.out.println(min*max);
	}
}
