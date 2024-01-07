import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M, T;
    static class info{
        int r;
        int c;
        int dist;
        int sword;
        info(int r, int c, int dist, int sword){
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.sword = sword;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); T = sc.nextInt();
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        BFS();
    }

    private static void BFS() {
        Queue<info> q = new LinkedList<>();
        boolean[][][] visited = new boolean[2][N][M];
        q.add(new info(0, 0, 0, 0));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            info now = q.poll();
            if(now.dist > T) continue;
            if(now.r == N-1 && now.c == M-1) {
                System.out.println(now.dist);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dir[i][0];
                int nc = now.c + dir[i][1];
                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                if(visited[now.sword][nr][nc]) continue;
                // 검 들고있을때
                if(now.sword == 1){
                    q.add(new info(nr, nc, now.dist+1, 1));
                    visited[1][nr][nc] = true;
                }
                // 검 없을때
                else {
                    if(arr[nr][nc] == 0) {
                        q.add(new info(nr, nc, now.dist+1, 0));
                        visited[0][nr][nc] = true;
                    }
                    else if(arr[nr][nc] == 2) {
                        q.add(new info(nr, nc, now.dist+1, 1));
                        visited[0][nr][nc] = true;
                        visited[1][nr][nc] = true;
                    }
                }
            }
        }
        System.out.println("Fail");
    }
}