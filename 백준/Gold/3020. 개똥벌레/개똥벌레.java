import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, H;
    static int[] cnt1, cnt2;

    public static void main(String[] args) throws IOException {
        input();
        // 누적합 처리
        for (int i = 1; i < H; i++) {
            cnt2[i] += cnt2[i-1];
        }
        for (int i = H-1; i >= 1; i--) {
            cnt1[i] += cnt1[i+1];
        }
        int answer = 0, min = Integer.MAX_VALUE;
        for (int i = 1; i <= H; i++) {
            int count = 0;
            count += cnt1[i];
            count += cnt2[i-1];

            if(min > count) {
                min = count;
                answer = 1;
            }
            else if(min == count) answer++;
        }
        System.out.println(min + " " + answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        cnt1 = new int[H+1];
        cnt2 = new int[H+1];
        for (int i = 0; i < N/2; i++) {
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            cnt1[n1]++;
            cnt2[H-n2]++;
        }
    }
}