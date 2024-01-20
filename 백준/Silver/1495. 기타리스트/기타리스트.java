import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, S, M;
    static int[] arr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        int[] dp = new int[M + 1];
        int ans = -1;
        List<Integer> l = new ArrayList<>();
        boolean flag = false;
        Arrays.fill(dp, -1);
        dp[S] = 0;
        for (int j = 1; j <= N; j++) {
            l.clear();
            for (int i = 0; i <= M; i++) {
                if(dp[i] == j-1) {
                    if(i + arr[j] <= M) l.add(i + arr[j]);
                    if(i - arr[j] >= 0) l.add(i - arr[j]);
                }
            }
            if(l.isEmpty()) {
                flag = true;
                break;
            }
            for(int t : l) {
                dp[t] = j;
                if(j == N) ans = Math.max(t, ans);
            }
        }
        if(flag) System.out.println(-1);
        else System.out.println(ans);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}