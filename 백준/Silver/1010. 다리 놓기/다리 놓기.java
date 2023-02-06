import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); 
			int M = Integer.parseInt(st.nextToken());
			System.out.println(combi(M, N));
			}
			
		
	}
	
	static int combi(int n, int r) {
		 
		// 이미 탐색했던 경우 바로 반환
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
	 
		// 2번 성질
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		// 1번 성질
		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}