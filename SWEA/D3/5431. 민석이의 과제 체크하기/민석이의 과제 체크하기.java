import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(), K = sc.nextInt();
			int[] arr = new int[N+1];
			for (int i = 0; i < K; i++) {
				arr[sc.nextInt()] = 1;
			}
			System.out.printf("#%d ",tc);
			for (int i = 1; i < arr.length; i++) {
				if(arr[i]==0)System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
