import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, answer = -1;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] visit;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        input();
        Set<Character> s = new HashSet<>();
        s.add(arr[0][0]);
        DFS(0, 0, s);
        System.out.println(answer);
    }

    private static void DFS(int r, int c, Set<Character> s) {
        answer = Math.max(answer, s.size());
        visit[r][c] = s.size();

        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
            if(s.contains(arr[nr][nc])) continue;
            s.add(arr[nr][nc]);
            DFS(nr, nc, s);
            s.remove(arr[nr][nc]);
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }
}