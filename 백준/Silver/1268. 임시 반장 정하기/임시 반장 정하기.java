import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        input();
        int answer = -1, max = -1;
        for (int i = 0; i < N; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if(i==j) continue;
                for (int k = 0; k < 5; k++) {
                    if(arr[i][k] == arr[j][k]) s.add(j);
                }
            }
            if(s.size() > max) {
                max = s.size();
                answer = i+1;
            }
        }
        System.out.print(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}