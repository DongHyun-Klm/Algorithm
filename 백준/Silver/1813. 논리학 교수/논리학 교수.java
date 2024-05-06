import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] cnt = new int[51];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            cnt[num]++;
        }
        int answer = -1;
        for (int i = 0; i <= 50; i++) {
            if(cnt[i] == i) answer = i;
        }
        System.out.print(answer);
    }
}