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
        Arrays.sort(arr);
        int ans = 0;
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if(s.contains(arr[i])) {
                ans++;
                continue;
            }
            int L = 0;
            int R = N-1;
            while (L<R) {
                if(L==i) {
                    L++;
                    continue;
                }
                if(R==i) {
                    R--;
                    continue;
                }
                int temp = arr[L] + arr[R];
                if(temp == arr[i]) {
                    ans++;
                    s.add(arr[i]);
                    break;
                }
                if(temp < arr[i]) L++;
                else R--;
            }
        }
        System.out.println(ans);
    }
    //
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}