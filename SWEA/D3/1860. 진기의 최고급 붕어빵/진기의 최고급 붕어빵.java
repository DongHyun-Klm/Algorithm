import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
			boolean flag = true;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append((tc+1)+" ");
			int[] time = new int[N];
			for (int i = 0; i < time.length; i++) {
				time[i] = sc.nextInt();
			}
			// 오는 순서 헷갈리니까 정렬 해놓자
			Arrays.sort(time);
			for (int i = 0; i < time.length; i++) {
				// 만들어진 붕어빵 개수
				int bbang = (time[i]/M) * K - i;
				if(bbang<=0) {
					flag = false;
					sb.append("Impossible");
					break;
				}
			}
			if(flag)sb.append("Possible");
			System.out.println(sb.toString());
		}
	}
}