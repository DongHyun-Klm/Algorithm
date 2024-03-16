import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] arr, melt, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        input();
        int answer = 0;
        while (true) {
            visit = new boolean[N][M];
            melt = new int[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j]==0) continue;
                    if(visit[i][j]) continue;
                    DFS(i, j);
                    cnt++;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] -= melt[i][j];
                    if(arr[i][j] < 0) arr[i][j] = 0;
                }
            }
            if(cnt > 1) break;
            else if(cnt == 0) {
                answer = 0;
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static void DFS(int r, int c) {
        visit[r][c] = true;
        for (int k = 0; k < 4; k++) {
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];
            if(nr<0||nc<0||nr>=N||nc>=M) continue;
            if(arr[nr][nc] == 0) {
                melt[r][c]++;
                continue;
            }
            if(visit[nr][nc]) continue;
            DFS(nr, nc);
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