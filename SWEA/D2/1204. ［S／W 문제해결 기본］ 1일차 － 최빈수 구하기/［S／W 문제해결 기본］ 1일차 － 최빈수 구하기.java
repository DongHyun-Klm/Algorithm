import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int[] cnt = new int[101];
			int number = sc.nextInt();
			
			//빈도수 찾기
			for (int j = 0; j < 1000; j++) {  
				cnt[sc.nextInt()] += 1;
			}
			
			//최대빈도값 구하기
			int max = Integer.MIN_VALUE;
			for (int j : cnt) {                   
				max = max<j ? j : max;
			}
			
			//index구하기
			for (int j = cnt.length-1; j >= 0; j--) {
				if (cnt[j] == max) {
					System.out.printf("#%d %d\n",number,j);
					break;
				}
			}
		}
	}
}