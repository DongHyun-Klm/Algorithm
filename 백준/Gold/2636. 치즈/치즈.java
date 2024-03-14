import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M, answer = 0, last = 0;
    static int[][] arr, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        while (!q.isEmpty()) {
            last = q.size();
            answer++;
            Queue<int[]> temp = new LinkedList<>();
            for (int i = 0; i < last; i++) {
                int[] now = q.poll();
                if(chkBFS(now[0],now[1])) temp.add(now);
                else q.add(now);
            }
            while (!temp.isEmpty()) {
                int[] now = temp.poll();
                arr[now[0]][now[1]] = 0;
            }
        }


        System.out.println(answer);
        System.out.println(last);
    }

    // 치즈가 외각이라면 true
    private static boolean chkBFS(int r, int c) {
        visit = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visit[r][c] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nr = now[0] + dir[k][0];
                int nc = now[1] + dir[k][1];
                if(nr<0||nc<0||nr>=N||nc>=M) return true;
                if(arr[nr][nc] == 1) continue;
                if(visit[nr][nc]) continue;
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
        return false;
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
                if(arr[i][j] == 1) q.add(new int[] {i,j});
            }
        }
    }
}