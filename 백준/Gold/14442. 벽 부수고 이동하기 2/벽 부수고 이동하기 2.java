import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class info{
        int r, c, dist, brk;

        public info(int r, int c, int dist, int brk) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.brk = brk;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] arr = new boolean[N][M];
        for (int i=0;i<N;i++){
            char[] temp = sc.next().toCharArray();
            for (int j=0;j<M;j++){
                if(temp[j] -'0' == 1) arr[i][j] = true;
            }
        }
        boolean[][][] visited = new boolean[N][M][K+1];
        Queue<info> q = new LinkedList<>();
        q.add(new info(0, 0, 1, 0));

        while(!q.isEmpty()){
            info now = q.poll();
            if(now.r == N-1 && now.c == M-1) {
                System.out.println(now.dist);
                return;
            }
            for(int i=0; i<4; i++){
                int nr = now.r + dir[i][0];
                int nc = now.c + dir[i][1];
                if(nr<0||nc<0||nr>=N||nc>=M) continue;
                if(visited[nr][nc][now.brk]) continue;
                // 길 있다면
                if(!arr[nr][nc] && !visited[nr][nc][now.brk]) {
                    q.add(new info(nr, nc, now.dist + 1, now.brk));
                    visited[nr][nc][now.brk] = true;
                    if(nr == N-1 && nc == M-1) {
                        System.out.println(now.dist+1);
                        return;
                    }
                }
                // 길 없지만 벽 뿌술 기회가 남았다면
                if(arr[nr][nc] && now.brk < K && !visited[nr][nc][now.brk]){
                    q.add(new info(nr, nc, now.dist + 1, now.brk + 1));
                    visited[nr][nc][now.brk] = true;
                    visited[nr][nc][now.brk + 1] = true;
                    if(nr == N-1 && nc == M-1) {
                        System.out.println(now.dist+1);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}