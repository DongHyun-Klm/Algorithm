import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  T =sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			int top = N-1, down = 0, cnt=0;
			while (top-down>0) {
				int n = 49/arr[top] + 1;
				if(top-down+1<n)break;
				else {
					if(n==1) {
						cnt++;
						top--;
					}
					else {
						cnt++;
						top--;
						for (int j = 0; j < n-1; j++) {
							down++;
						}
					}
				}
			}
			if(top==down) {
				if(arr[top]>=50)cnt++;
			}
			System.out.printf("#%d %d\n",i+1,cnt);
		}
	}
}
