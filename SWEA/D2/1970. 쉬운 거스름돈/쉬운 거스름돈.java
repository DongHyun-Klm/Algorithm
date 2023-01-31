import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			System.out.printf("#%d\n",i);
			for (int j = 0; j < arr.length; j++) {
				if (j==0) {
					System.out.print(N/50000 + " ");
				}
				else {
				System.out.print((N%arr[j-1])/arr[j] + " ");
				}
			}
			System.out.println();
		}
	}
}