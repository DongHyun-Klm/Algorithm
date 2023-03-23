import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), max = Integer.MIN_VALUE;
		Integer[] arr = new Integer[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			arr[i] += i+1;
			max = Math.max(arr[i], max);
		}
		System.out.println(max+1);
	}
}