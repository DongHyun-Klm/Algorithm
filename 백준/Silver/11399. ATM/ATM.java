import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int time = 0;
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i-1];
		}
		for (int i = 0; i < arr.length; i++) {
			time += arr[i];
		}
		System.out.println(time);
	}
}
