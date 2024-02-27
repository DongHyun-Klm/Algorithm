import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] arr, up;

    public static void main(String[] args) throws IOException {
        input();
        // 스스로 자라는 애들
        int[] self = new int[2 * M - 1];
        for (int i = 0; i < N; i++) {
            if(up[i][1] == 0) {
                if(up[i][2] != 0) self[up[i][0]] += 2;
            }
            else {
                self[up[i][0]] += 1;
                if(up[i][2] != 0) self[up[i][0]+up[i][1]] += 1;
            }
        }
        // 누적합 처리
        for (int i = 1; i < self.length; i++) {
            self[i] += self[i-1];
        }
        // 스스로 자라는 애들 성장
        for (int i = 1; i <= M; i++) {
            arr[M-i][0] += self[i-1];
        }
        for (int i = 1; i < M; i++) {
            arr[0][i] += self[M+i-1];
        }
        // 나머지 애들 성장
        for (int j = 1; j < M; j++) {
            for (int k = 1; k < M; k++) {
                arr[k][j] = arr[k-1][j];
            }
        }
        // 출력
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][M];
        up = new int[N][3];
        for (int i = 0; i < M; i++) Arrays.fill(arr[i], 1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                up[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}