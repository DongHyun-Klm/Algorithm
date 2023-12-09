import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static class info {
        int r;
        int c;
        int dist;
        public info(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int L = sc.nextInt(), W = sc.nextInt();
        char[][] arr = new char[L][W];
        for (int i = 0; i < L; i++) {
            arr[i] = sc.next().toCharArray();
        }
        Queue<info> q = new LinkedList<>();
        // 시작점 후보 찾기
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if(arr[i][j] == 'W') continue;
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dir[k][0], nc = j + dir[k][1];
                    if(nr>=L || nc>=W || nr<0 || nc<0) continue;
                    if(arr[nr][nc] == 'L') count++;
                }
                if(count < 3)  q.add(new info(i, j, 0));
            }
        }
        // 최장거리 구하기
        Queue<info> q2 = new LinkedList<>();
        while(!q.isEmpty()){
            info start = q.poll();
            q2.add(start);
            boolean[][] visited = new boolean[L][W];
            visited[start.r][start.c] = true;
            while (!q2.isEmpty()) {
                info now = q2.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = now.r + dir[k][0], nc = now.c + dir[k][1];
                    if(nr>=L || nc>=W || nr<0 || nc<0) continue;
                    if(visited[nr][nc]) continue;
                    if(arr[nr][nc] == 'L') {
                        q2.add(new info(nr, nc, now.dist + 1));
                        answer = Math.max(answer, now.dist + 1);
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}