import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        int[][][][] dp = new int[N + 1][10][10][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i][i][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int cur : new int[]{j + 1, j - 1}) {
                            if(cur < 0 || cur > 9) continue;
                            dp[i][cur][Math.max(cur, k)][Math.min(cur, l)] += dp[i-1][j][k][l];
                            dp[i][cur][Math.max(cur, k)][Math.min(cur, l)] %= 1000000000;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i][9][0];
            ans %= 1000000000;
        }
        System.out.println(ans);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }
}