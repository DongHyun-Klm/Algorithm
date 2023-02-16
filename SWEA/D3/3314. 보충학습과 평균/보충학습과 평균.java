import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				int num = sc.nextInt();
				if(num<40) {
					num=40;
				}
				sum += num;
			}
			System.out.printf("#%d %d\n",i+1,sum/5);
		}
	}
}
