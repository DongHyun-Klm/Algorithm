import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		for (int i = 1; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1]!=o2[1])return o1[1] - o2[1];
				else return o1[0] - o2[0];
			}
		});
		int[][] dp = new int[N+1][2];
		if(arr[1][1]!=0)
			dp[1][0] = 1; 
		dp[1][1] = arr[1][1];
		for (int i = 2; i < N+1; i++) {
			// 선택 안하는 경우
			if(arr[i][0] < dp[i-1][1]) {
				dp[i][0] = dp[i-1][0];
				dp[i][1] = dp[i-1][1];
			}
			// 선택 하는 경우
			else {
				if(arr[i][1]!=0)
				dp[i][0] = dp[i-1][0] + 1;
				dp[i][1] = arr[i][1];
			}
		}
		
		System.out.println(dp[N][0]);
	}
}