import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) arr[i] = new ArrayList<>();
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			arr[U].add(V);
			arr[V].add(U);
		}
		dp = new int[N+1];
		DFS(R, -1);
		for (int i = 0; i < Q; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.println(sb.toString());
	}

	private static void DFS(int x, int last) {
		dp[x] = 1;
		for(int t : arr[x]) {
			if(t==last) continue;
			DFS(t,x);
			dp[x] += dp[t];
		}
	}
}