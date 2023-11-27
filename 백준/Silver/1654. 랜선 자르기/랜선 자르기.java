
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static long binary(long start, long end, int[] arr, int N) {
		if (start > end)
			return end;
		Long m = (start + end) / 2;
		long sum =0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] / m;
		}
		if (sum >= N)
			return binary(m + 1, end, arr, N);
		else
			return binary(start, m - 1, arr, N);
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(), N = sc.nextInt();
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(binary(1,Arrays.stream(arr).max().getAsInt(),arr,N));
	}
}