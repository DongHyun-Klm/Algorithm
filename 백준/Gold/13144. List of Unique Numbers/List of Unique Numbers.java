import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        int L = 0, R = 0;
        long ans = 0;
        boolean[] chk = new boolean[N+1];
        while(R < N)
        {
            if(chk[arr[R]]) {
                chk[arr[L]] = false;
                L++;
                continue;
            }
            chk[arr[R]] = true;
            ans += R - L + 1;
            R++;
        }
        System.out.print(ans);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}