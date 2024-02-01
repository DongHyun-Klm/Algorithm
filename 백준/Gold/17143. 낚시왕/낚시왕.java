import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C, M;
    static int[][] arr, dir = {{0,-1},{-1,0},{0,1},{1,0}};
    static shark[] sharks;
    static class shark {
        int r, c, s, d, z;
        boolean eat;

        public shark(int r, int c, int s, int d, int z, boolean eat) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.eat = eat;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        int index = 0, answer = 0;
        while (true) {
            // 오른쪽으로 한칸 이동한다
            index++;
            if(index > C) break;
            // 제일 가까운 상어를 잡는다 -> 상어는 사라진다
            for (int i = 1; i <= R; i++) {
                if(arr[i][index] != 0) {
                    answer += sharks[arr[i][index]].z;
                    sharks[arr[i][index]].eat = true;
                    arr[i][index] = 0;
                    break;
                }
            }
            //상어가 이동한다
            moveSharks();
        }
        System.out.println(answer);
    }
    // d 0123 : 왼아오위
    private static void moveSharks() {
        arr = new int[R+1][C+1];
        for (int i = 1; i <= M; i++) {
            shark now = sharks[i];
            if(now.eat) continue;
            // 상어 이동
            int size;
            if(now.d == 1 || now.d == 3) size = (R-1) * 2;
            else size = (C-1) * 2;

            for (int k = 0; k < now.s % size; k++) {
                // 벽이면 방향전환
                if(now.r + dir[now.d][0] > R || now.r + dir[now.d][0] <= 0 ||
                        now.c + dir[now.d][1] > C || now.c + dir[now.d][1] <= 0) now.d = (now.d + 2) % 4;
                now.r += dir[now.d][0];
                now.c += dir[now.d][1];
            }

            // 가장 큰 상어가 나머지 잡아먹음, 배열에 위치저장
            if(arr[now.r][now.c] != 0) {
                if(sharks[arr[now.r][now.c]].z > now.z) {
                    now.eat = true;
                    continue;
                }
                else sharks[arr[now.r][now.c]].eat = true;
            }
            arr[now.r][now.c] = i;
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharks = new shark[M+1];
        // 상어의 index를 가지고있을 배열
        arr = new int[R+1][C+1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            // 방향전환 편하게 하려고 바꿈
            if(d==2) d = 3;
            else if(d==3) d = 2;
            else if(d==4) d = 0;
            arr[r][c] = i;
            sharks[i] = new shark(r, c, s, d, z, false);
        }
    }
}