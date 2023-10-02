import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i+1] = Integer.parseInt(st.nextToken());
        boolean[][] dp = new boolean[N+1][N+1];
        // 초기값
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < N; i++) {
            dp[i][i+1] = arr[i] == arr[i+1];
        }
        // dp
        for (int i = 2; i < N; i++) {
            for (int j = 1; j+i <= N; j++) {
                if(arr[j] != arr[j+i]) continue;
                dp[j][j+i] = dp[j+1][j+i-1];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] ? 1 : 0).append('\n');
        }
        System.out.print(sb);
    }
}