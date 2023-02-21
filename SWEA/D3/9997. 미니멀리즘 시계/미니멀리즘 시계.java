import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int degree = sc.nextInt();
			System.out.printf("#%d %d %d\n",i+1,degree/30,degree%30*2);
		}
	}
}
