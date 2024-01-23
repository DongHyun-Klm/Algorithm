import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        int[][] dp = new int[K][K]; // dp[a][b]는 행렬 a~b를 연산했을 때의 연산수 최소값
        for (int len = 2; len <= K; len++) {
            for (int s = 0; s <= K - len; s++) {
                int end = s + len - 1;
                dp[s][end] = Integer.MAX_VALUE;
                for (int i = s; i < end; i++) {
                    dp[s][end] = Math.min(dp[s][end],
                            dp[s][i] + dp[i+1][end] + arr[s][0] * arr[i][1] * arr[end][1]
                            );
                }
            }
        }
        System.out.println(dp[0][K-1]);
    }

    private static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        arr = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}