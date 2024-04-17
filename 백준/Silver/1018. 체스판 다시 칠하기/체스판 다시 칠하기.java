import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, ans = 100;
    static char[][] arr, WB, BW;

    public static void main(String[] args) throws IOException {
        input();
        // 왼쪽 위칸이 흰색인경우
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j) % 2 == 0) WB[i][j] = 'W';
                else WB[i][j] = 'B';
            }
        }

        // 왼쪽 위칸이 검은색인경우
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j) % 2 == 0) BW[i][j] = 'B';
                else BW[i][j] = 'W';
            }
        }

        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                chk(i,j);
            }
        }
        System.out.println(ans);
    }

    private static void chk(int r, int c) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(arr[r+i][c+j] != WB[i][j]) cnt1++;
                if(arr[r+i][c+j] != BW[i][j]) cnt2++;
            }
        }

        ans = Math.min(ans, cnt1);
        ans = Math.min(ans, cnt2);
    }


    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        WB = new char[8][8];
        BW = new char[8][8];
        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp[j];
            }
        }
    }
}