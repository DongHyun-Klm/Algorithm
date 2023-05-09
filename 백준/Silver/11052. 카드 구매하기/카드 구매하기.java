import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] card = new int[N+1];
		int[] dp = new int[1001];
		for(int i=1;i<=N;i++)card[i]=Integer.parseInt(st.nextToken());
		dp[1] = card[1];
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if(i%j==0) dp[i] = Math.max(dp[j]*(i/j), dp[i]);
				dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
			}
			dp[i] = Math.max(dp[i], card[i]);
		}
		System.out.println(dp[N]);
	}
}