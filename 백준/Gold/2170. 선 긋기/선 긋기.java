import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(arr, (a,b) -> {
            if(a[0]==b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int answer = arr[0][1] - arr[0][0];
        int last = arr[0][1];
        for (int i = 1; i < N; i++) {
            if(arr[i][0] >= last) {
                answer += arr[i][1] - arr[i][0];
                last = arr[i][1];
                continue;
            }
            if(arr[i][1] > last) {
                answer += arr[i][1] - last;
                last = arr[i][1];
            }
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}