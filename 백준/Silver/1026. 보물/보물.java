import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] arr2 = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		Arrays.sort(arr2);
		int sum = 0;
		for (int i = 0; i < arr2.length; i++) {
			sum += arr[i] * arr2[N-1-i];
		}
		System.out.println(sum);
	}
}