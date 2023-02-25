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
			int[] temp = new int[N];
			for (int k = i; k <= j; k++) {
				temp[k-1] = arr[k-1]; 
			}
			for (int k = j; k >= i; k--) {
				arr[i+j-k-1] = temp[k-1];
			}
		}
		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
	}
}
