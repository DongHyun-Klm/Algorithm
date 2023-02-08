import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int k = sc.nextInt();
			double number = sc.nextInt(), power = sc.nextInt();
			int a =(int)Math.pow(number, power);
			System.out.printf("#%d %d\n", i, a);
		}
	}
}
