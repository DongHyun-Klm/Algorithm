import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M, answer = 0, max = 0, cnt;
    static int[][] arr, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        input();
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j]) continue;
                if(arr[i][j] == 0) continue;
                cnt = 0;
                DFS(i,j);
                answer++;
                max = Math.max(max, cnt);
            }
        }
        System.out.println(answer);
        System.out.println(max);
    }

    private static void DFS(int i, int j) {
        visit[i][j] = true;
        cnt++;
        for (int k = 0; k < 4; k++) {
            int nr = i + dir[k][0];
            int nc = j + dir[k][1];
            if(nr<0||nc<0||nr>=N||nc>=M) continue;
            if(arr[nr][nc] == 0) continue;
            if(visit[nr][nc]) continue;
            DFS(nr,nc);
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}