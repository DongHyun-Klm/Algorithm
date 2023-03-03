import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// 필요한 동전 개수
		int count = 0, index = N-1;
		// k = 0 될 때까지
		while (K!=0) {
			if(arr[index] <= K) {
				count += K/arr[index];
				K %= arr[index];
			}
			index--;
		}
		System.out.println(count);
	}
}