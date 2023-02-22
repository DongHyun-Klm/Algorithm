import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			long sum = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			for (int j = 0; j < arr.length-1; j++) {
				for (int j2 = j+1; j2 < arr.length; j2++) {
					sum += GCD(arr[j], arr[j2]);
				}
			}
			System.out.println(sum);
		}
	}
	
	private static int GCD(int a, int b) {
		if(b==0) return a;
		else {
			return GCD(b, a%b);
		}
	}
}
