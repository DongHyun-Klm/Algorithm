import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] T, P;

    public static void main(String[] args) throws IOException {
        input();
        int answer = 0;
        int[] dp = new int[N+2];
        for (int i = 1; i <= N+1; i++) {
            int endDay = i + T[i];
            if(dp[i] < answer) dp[i] = answer;
            if(endDay <= N+1) {
                dp[endDay] = Math.max(dp[endDay], dp[i] + P[i]);
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = new int[N+2];
        P = new int[N+2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
    }
}