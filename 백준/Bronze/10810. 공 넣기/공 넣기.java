import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] arr = new int[N];
		for (int t = 0; t < M; t++) {
			int i = sc.nextInt(), j = sc.nextInt(), k = sc.nextInt();
			for (int k2 = i; k2 <= j; k2++) {
				arr[k2-1] = k;
			}
		}
		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
	}
}
