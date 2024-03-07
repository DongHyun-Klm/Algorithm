import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static char[][] arr;
    static boolean[][] visit1, visit2;

    public static void main(String[] args) throws IOException {
        input();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit1[i][j]) {
                    cnt1++;
                    DFS1(i, j);
                }
                if(!visit2[i][j]) {
                    cnt2++;
                    DFS2(i, j);
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }


    private static void DFS1(int r, int c) {
        visit1[r][c] = true;
        for (int k = 0; k < 4; k++) {
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];
            if(nr>=N||nc>=N||nr<0||nc<0) continue;
            if(visit1[nr][nc]) continue;
            if(arr[nr][nc] != arr[r][c]) continue;
            DFS1(nr, nc);
        }
    }

    private static void DFS2(int r, int c) {
        visit2[r][c] = true;
        for (int k = 0; k < 4; k++) {
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];
            if(nr>=N||nc>=N||nr<0||nc<0) continue;
            if(visit2[nr][nc]) continue;
            if(arr[r][c] == 'B') {
                if(arr[nr][nc] != 'B') continue;
            }
            else {
                if(arr[nr][nc] == 'B') continue;
            }
            DFS2(nr, nc);
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        visit1 = new boolean[N][N];
        visit2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }
}