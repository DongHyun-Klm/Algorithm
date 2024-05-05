import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C;
    static boolean[][] wall;
    static Queue<info> q = new LinkedList<>();
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][][] visit;
    static int[][] cnt;
    static class info{
        int r, c, num, dis;
        public info(int r, int c, int num, int dis) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        while (!q.isEmpty()) {
            int size = q.size();
            int minTime = q.peek().dis + 1;
            while (size-- > 0) {
                info f = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = f.r + dir[i][0];
                    int nc = f.c + dir[i][1];
                    if(nr<0||nc<0||nr>=R||nc>=C) continue;
                    if(wall[nr][nc]) continue;
                    if(visit[f.num][nr][nc]) continue;
                    cnt[nr][nc]++;
                    visit[f.num][nr][nc] = true;
                    q.add(new info(nr, nc, f.num, f.dis + 1));
                }
            }
            // cnt가 3이면 모일 수 있는 지점
            boolean flag = false;
            int count = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(cnt[i][j] == 3) {
                        flag = true;
                        count++;
                    }
                }
            }
            if(flag) {
                System.out.println(minTime);
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        wall = new boolean[R][C];
        visit = new boolean[3][R][C];
        cnt = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                wall[i][j] = temp[j] != '0';
            }
        }
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            q.add(new info(r,c,i,0));
            visit[i][r][c] = true;
            cnt[r][c]++;
        }
    }
}