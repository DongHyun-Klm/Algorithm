import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int[] arr = {1,4,9,121,484};
			int A = sc.nextInt(), B =sc.nextInt(), cnt =0;
			for (int j = A; j <= B; j++) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					if(j == arr[j2]) cnt++;
				}
			}
			System.out.printf("#%d %d\n",i,cnt);
		}
	}
}
