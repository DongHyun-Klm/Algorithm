import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            int ans = 0;
            int[][] dp = new int[K][K];
            int[][] sum = new int[K][K];
            for (int j = 0; j < K; j++) {
                for (int k = j; k < K; k++) {
                    if(k==0) sum[j][k] = arr[k];
                    else sum[j][k] = sum[j][k-1] + arr[k];
                }
            }
            for (int j = 1; j < K; j++) {
                for (int k = 0; k < K-j; k++) {
                    int end = k + j;
                    dp[k][end] = Integer.MAX_VALUE;
                    for (int l = k; l < end; l++) {
                        dp[k][end] = Math.min(dp[k][end],
                                dp[k][l] + dp[l + 1][end] + sum[k][end]);
                    }
                }
            }
            System.out.println(dp[0][K-1]);
        }
    }

    private static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}