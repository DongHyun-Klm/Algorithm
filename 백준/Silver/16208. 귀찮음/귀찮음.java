import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(arr);
        long answer = 0;
        for (int i = 0; i < N; i++) {
            sum -= arr[i];
            answer += arr[i] * sum;
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
    }
}