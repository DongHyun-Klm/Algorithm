import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt(), M = sc.nextInt(); // N사람 M문제
			int[] arr = new int[N];
			int max = Integer.MIN_VALUE, index =-1, cnt=0;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(sc.nextInt()==1)arr[j]++;
				}
			}
			for (int j = 0; j < arr.length; j++) {
				max = Math.max(max, arr[j]);
				if(max==arr[j]) index = j+1;
			}
			for (int j = 0; j < arr.length; j++) {
				if(arr[j]==max)cnt++;
			}
			System.out.printf("#%d %d %d\n",i+1,cnt,max);
		}
	}
}
