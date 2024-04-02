import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, d, k, c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        int max = 0, point = 0;
        Set<Integer> s = new HashSet<>();
        int[] count = new int[d+1];
        for (int i = 0; i < k; i++) {
            if(count[arr[i]] == 0) s.add(arr[i]);
            count[arr[i]]++;
        }
        max = s.size();
        if(count[c] == 0) max++;

        while (point < N) {
            point++;
            count[arr[point-1]]--;
            if(count[arr[point-1]] == 0) s.remove(arr[point-1]);
            count[arr[point+k-1]]++;
            if(count[arr[point+k-1]] == 1) s.add(arr[point+k-1]);

            if(count[c] == 0) max = Math.max(max, s.size() + 1);
            else max = Math.max(max, s.size());
        }

        System.out.print(max);
    }


    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[2*N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N; i < 2 * N; i++) {
            arr[i] = arr[i-N];
        }
    }
}