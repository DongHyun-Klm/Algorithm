import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, count;
    static char[][] arr;
    static boolean[][] visit;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
        input();
        count = 0;
        int total = 0;
        // 진원지 찾기
        int originR = -1, originC = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == '@') {
                    originR = i;
                    originC = j;
                }
                else if(arr[i][j] == '*' || arr[i][j] == '#') total++;
            }
        }
        // 본진
        bombOrigin(originR, originC);
        sb.append(count).append(' ').append(total - count);
        System.out.print(sb);
    }

    // 본진
    private static void bombOrigin(int originR, int originC) {
        for (int k = 0; k < 4; k++) {
            for (int d = 1; d <= 2; d++) {
                int nr = originR + dir[k][0] * d;
                int nc = originC + dir[k][1] * d;
                if(nr<0||nc<0||nr>=N||nc>=M) break;
                if(arr[nr][nc] == '|') break;
                if(arr[nr][nc] == '#') arr[nr][nc] = '*';
                else if(arr[nr][nc] == '*') {
                    arr[nr][nc] = '.';
                    count++;
                    bombSub(nr,nc);
                }
            }
        }
    }

    // 여진
    private static void bombSub(int r, int c) {
        for (int k = 0; k < 4; k++) {
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];
            if(nr<0||nc<0||nr>=N||nc>=M) continue;
            if(arr[nr][nc] == '|') continue;
            if(arr[nr][nc] == '#') arr[nr][nc] = '*';
            else if(arr[nr][nc] == '*') {
                arr[nr][nc] = '.';
                count++;
                bombSub(nr,nc);
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }
}