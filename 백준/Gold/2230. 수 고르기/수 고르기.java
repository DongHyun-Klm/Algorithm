import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            int L = i + 1, R = N - 1;
            while (L <= R) {
                int mid = (L + R) / 2;
                int now = arr[mid] - arr[i];
                if(now >= M) {
                    ans = Math.min(ans, now);
                    R = mid - 1;
                }
                else L = mid + 1;
            }
        }
        System.out.print(ans);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}