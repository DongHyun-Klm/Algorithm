import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans = 0;
    static int[] cnt = new int[65];

    public static void main(String[] args) throws IOException {
        input();
        cnt[64]++;
        rec(64, 64);
        System.out.println(ans);
    }

    private static void rec(int small, int sum) {
        if(sum == N) {
            for (int i = 1; i <= 64; i++) {
                ans += cnt[i];
            }
            return;
        }
        if(sum > N) {
            cnt[small]--;
            small /= 2;
            cnt[small] += 2;
            if(sum - small >= N) {
                sum -= small;
                cnt[small]--;
            }
            rec(small, sum);
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }
}