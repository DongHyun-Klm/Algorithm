import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, H;
    static int[][] arr;
    static int jin_r = -1, jin_c = -1, answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] != 2) continue;
                int dis = Math.abs(i - jin_r) + Math.abs(j - jin_c);
                // 현재 체력으로 갈 수 없다면 패스
                if(dis > M) continue;
                arr[i][j] = 0;
                BT(M - dis + H, i, j, 1);
                arr[i][j] = 2;
            }
        }
        System.out.print(answer);
    }

    private static void BT(int hp, int r, int c, int eat) {
        // 집으로 돌아갈 수 있는지
        int dis_home = Math.abs(r - jin_r) + Math.abs(c - jin_c);
        if(dis_home <= hp && eat > answer) {
            answer = eat;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] != 2) continue;
                int dis = Math.abs(i - r) + Math.abs(j - c);
                // 현재 체력으로 갈 수 없다면 패스
                if(dis > hp) continue;
                arr[i][j] = 0;
                BT(hp - dis + H, i, j, eat+1);
                arr[i][j] = 2;
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    jin_r = i;
                    jin_c = j;
                }
            }
        }
    }
}