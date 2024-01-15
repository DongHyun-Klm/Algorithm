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
        int R = 1, ans = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            while (R < N - 1 && arr[R] - arr[i] < M) R++;
            if(arr[R] - arr[i] >= M) ans = Math.min(ans, arr[R] - arr[i]);
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