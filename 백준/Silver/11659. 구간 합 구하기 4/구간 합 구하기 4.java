import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + now;
        }
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());
            if(i!=1) sb.append(arr[j] - arr[i-1]).append('\n');
            else sb.append(arr[j]).append('\n');
        }
        System.out.print(sb);
    }
}