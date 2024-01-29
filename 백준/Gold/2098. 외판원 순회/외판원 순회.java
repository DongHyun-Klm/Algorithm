import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr, dp;
    static int INF = 2000000000;
    static int N, answer = INF;

    public static void main(String[] args) throws IOException {
        input();
        // dp[b][c]는 다녀온 도시를 비트로 표현한 수를 b 현재 있는 도시의 위치를 c 라고 했을때 비용 최소값
        dp = new int[1 << N][N + 1];
        for (int i = 0; i < 1 << N; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[1][1] = 0;

        DFS(1,1);
        System.out.println(answer);
    }

    private static void DFS(int visited, int now) {
        if(visited == (1 << N) - 1) {
            if(arr[now][1] == 0) return;
            answer = Math.min(answer, dp[visited][now] + arr[now][1]);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if((visited & (1 << (i-1))) != 0) continue;
            if(arr[now][i] == 0) continue;
            if(dp[visited][now] + arr[now][i] < dp[visited | (1 << (i-1))][i]) {
                dp[visited | (1 << (i-1))][i] = dp[visited][now] + arr[now][i];
                DFS(visited | (1 << (i-1)), i);
            }
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr= new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}