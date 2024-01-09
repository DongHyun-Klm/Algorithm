import java.util.*;

public class Main {
    static int N, M, answer = 1;
    static int[][] arr, dp, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static Scanner sc = new Scanner(System.in);

    static class info {
        int r;
        int c;
        int dist;

        public info(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "info{" +
                    "r=" + r +
                    ", c=" + c +
                    ", dist=" + dist +
                    '}';
        }
    }

    public static void main(String[] args) {
        input();
        dp = new int[N][M];
        visited = new boolean[N][M];
        visited[0][0] = true;
        DFS(new info(0, 0, 1));
        if (answer == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.println(answer);
    }

    private static void DFS(info point) {
        int size = arr[point.r][point.c];
        for (int i = 0; i < 4; i++) {
            int nr = point.r + size * dir[i][0];
            int nc = point.c + size * dir[i][1];
            if (nr >= N || nc >= M || nr < 0 || nc < 0) continue;
            if (visited[nr][nc]) {
                answer = Integer.MAX_VALUE;
                return;
            }
            if(dp[nr][nc] > point.dist) continue;
            if(arr[nr][nc] == 0) continue;
            answer = Math.max(answer, point.dist + 1);
            dp[nr][nc] = point.dist + 1;
            visited[nr][nc] = true;
            DFS(new info(nr, nc, point.dist + 1));
            visited[nr][nc] = false;
        }
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] temp = sc.next().toCharArray();
            for (int j = 0; j < M; j++) {
                if (temp[j] == 'H') temp[j] = '0';
                arr[i][j] = temp[j] - '0';
            }
        }
    }
}