import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		for (int t = 0; t < M; t++) {
			int i = sc.nextInt(), j = sc.nextInt();
			int temp = arr[i-1];
			arr[i-1] = arr[j-1];
			arr[j-1] = temp;
		}
		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
	}
}
