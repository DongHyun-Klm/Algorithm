import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int last = arr[N-1];
		int ans = 0;
		for (int i = N-2; i >= 0; i--) {
			while(last<=arr[i]) {
				arr[i]--;
				ans++;
			}
			last = arr[i];
		}
		System.out.println(ans);
	}
}