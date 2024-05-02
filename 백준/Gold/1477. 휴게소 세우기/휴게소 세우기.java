import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        int min = L, left = 1, right = L;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                int last = arr[i-1];
                while(arr[i] - last > mid) {
                    cnt++;
                    last += mid;
                }
            }
            if(cnt > M) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                min = Math.min(min, mid);
            }
        }
        System.out.println(min);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N+2];
        arr[0] = 0;
        arr[N+1] = L;
        if(N!=0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);
    }
}