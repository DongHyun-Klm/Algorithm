import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] arr, dir1 = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        input();
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(arr[r][c] == 0) cnt++;
            }
        }
        answer = Math.min(answer, cnt);
        o:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] != 0 && arr[i][j] !=6) {
                    surve(i, j, arr);
                    break o;
                }
            }
        }
        System.out.println(answer);
    }

    private static void surve(int i, int j, int[][] ar) {
        if(ar[i][j] == 1) {
            for (int k = 0; k < 4; k++) {
                // 감시구역 처리
                int[][] copy = new int[N][M];
                for (int l = 0; l < N; l++) copy[l] = ar[l].clone();
                CCTV1(i,j,k,copy);
                // 그다음 찾기
                o:
                for (int l = i; l < N; l++) {
                    if(l == i) {
                        for (int m = j+1; m < M; m++) {
                            if(arr[l][m] != 0 && arr[l][m] !=6) {
                                surve(l, m, copy);
                                break o;
                            }
                        }
                    }
                    else {
                        for (int m = 0; m < M; m++) {
                            if(arr[l][m] != 0 && arr[l][m] !=6) {
                                surve(l, m, copy);
                                break o;
                            }
                        }
                    }
                    if(l == N - 1) {
                        int cnt = 0;
                        for (int r = 0; r < N; r++) {
                            for (int c = 0; c < M; c++) {
                                if(copy[r][c] == 0) cnt++;
                            }
                        }
                        answer = Math.min(answer, cnt);
                    }
                }
            }
        }
        else if(ar[i][j] == 2) {
            for (int k = 0; k < 2; k++) {
                // 감시구역 처리
                int[][] copy = new int[N][M];
                for (int l = 0; l < N; l++) copy[l] = ar[l].clone();
                CCTV2(i,j,k,copy);
                // 그다음 찾기
                o:
                for (int l = i; l < N; l++) {
                    if(l == i) {
                        for (int m = j+1; m < M; m++) {
                            if(arr[l][m] != 0 && arr[l][m] !=6) {
                                surve(l, m, copy);
                                break o;
                            }
                        }
                    }
                    else {
                        for (int m = 0; m < M; m++) {
                            if(arr[l][m] != 0 && arr[l][m] !=6) {
                                surve(l, m, copy);
                                break o;
                            }
                        }
                    }
                    if(l == N - 1) {
                        int cnt = 0;
                        for (int r = 0; r < N; r++) {
                            for (int c = 0; c < M; c++) {
                                if(copy[r][c] == 0) cnt++;
                            }
                        }
                        answer = Math.min(answer, cnt);
                    }
                }
            }
        }
        else if(ar[i][j] == 3) {
            for (int k = 0; k < 4; k++) {
                // 감시구역 처리
                int[][] copy = new int[N][M];
                for (int l = 0; l < N; l++) copy[l] = ar[l].clone();
                CCTV3(i,j,k,copy);
                // 그다음 찾기
                o:
                for (int l = i; l < N; l++) {
                    if(l == i) {
                        for (int m = j+1; m < M; m++) {
                            if(arr[l][m] != 0 && arr[l][m] !=6) {
                                surve(l, m, copy);
                                break o;
                            }
                        }
                    }
                    else {
                        for (int m = 0; m < M; m++) {
                            if(arr[l][m] != 0 && arr[l][m] !=6) {
                                surve(l, m, copy);
                                break o;
                            }
                        }
                    }
                    if(l == N - 1) {
                        int cnt = 0;
                        for (int r = 0; r < N; r++) {
                            for (int c = 0; c < M; c++) {
                                if(copy[r][c] == 0) cnt++;
                            }
                        }
                        answer = Math.min(answer, cnt);
                    }
                }
            }
        }
        else if(ar[i][j] == 4) {
            for (int k = 0; k < 4; k++) {
                // 감시구역 처리
                int[][] copy = new int[N][M];
                for (int l = 0; l < N; l++) copy[l] = ar[l].clone();
                CCTV4(i,j,k,copy);
                // 그다음 찾기
                o:
                for (int l = i; l < N; l++) {
                    if(l == i) {
                        for (int m = j+1; m < M; m++) {
                            if(arr[l][m] != 0 && arr[l][m] !=6) {
                                surve(l, m, copy);
                                break o;
                            }
                        }
                    }
                    else {
                        for (int m = 0; m < M; m++) {
                            if(arr[l][m] != 0 && arr[l][m] !=6) {
                                surve(l, m, copy);
                                break o;
                            }
                        }
                    }
                    if(l == N - 1) {
                        int cnt = 0;
                        for (int r = 0; r < N; r++) {
                            for (int c = 0; c < M; c++) {
                                if(copy[r][c] == 0) cnt++;
                            }
                        }
                        answer = Math.min(answer, cnt);
                    }
                }
            }
        }
        else if(ar[i][j] == 5) {
            // 감시구역 처리
            int[][] copy = new int[N][M];
            for (int l = 0; l < N; l++) copy[l] = ar[l].clone();
            CCTV5(i,j,copy);
            // 그다음 찾기
            o:
            for (int l = i; l < N; l++) {
                if(l == i) {
                    for (int m = j+1; m < M; m++) {
                        if(arr[l][m] != 0 && arr[l][m] !=6) {
                            surve(l, m, copy);
                            break o;
                        }
                    }
                }
                else {
                    for (int m = 0; m < M; m++) {
                        if(arr[l][m] != 0 && arr[l][m] !=6) {
                            surve(l, m, copy);
                            break o;
                        }
                    }
                }
                if(l == N - 1) {
                    int cnt = 0;
                    for (int r = 0; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if(copy[r][c] == 0) cnt++;
                        }
                    }
                    answer = Math.min(answer, cnt);
                }
            }

        }
    }

    private static void CCTV5(int r, int c, int[][] copy) {
        for (int i = 0; i < 4; i++) {
            int nr = r;
            int nc = c;
            while (true) {
                nr += dir1[i][0];
                nc += dir1[i][1];
                if(nr >= N || nc >= M || nr < 0 || nc < 0 || copy[nr][nc] == 6) break;
                if(copy[nr][nc] == 0) copy[nr][nc] = -1;
            }
        }
    }

    private static void CCTV4(int r, int c, int k, int[][] copy) {
        int nr = r;
        int nc = c;
        while (true) {
            nr += dir1[k][0];
            nc += dir1[k][1];
            if(nr >= N || nc >= M || nr < 0 || nc < 0 || copy[nr][nc] == 6) break;
            if(copy[nr][nc] == 0) copy[nr][nc] = -1;
        }
        k += 1;
        k %= 4;
        nr = r;
        nc = c;
        while (true) {
            nr += dir1[k][0];
            nc += dir1[k][1];
            if(nr >= N || nc >= M || nr < 0 || nc < 0 || copy[nr][nc] == 6) break;
            if(copy[nr][nc] == 0) copy[nr][nc] = -1;
        }

        k += 1;
        k %= 4;
        while (true) {
            r += dir1[k][0];
            c += dir1[k][1];
            if(r >= N || c >= M || r < 0 || c < 0 || copy[r][c] == 6) break;
            if(copy[r][c] == 0) copy[r][c] = -1;
        }
    }

    private static void CCTV3(int r, int c, int k, int[][] copy) {
        int nr = r;
        int nc = c;
        while (true) {
            nr += dir1[k][0];
            nc += dir1[k][1];
            if(nr >= N || nc >= M || nr < 0 || nc < 0 || copy[nr][nc] == 6) break;
            if(copy[nr][nc] == 0) copy[nr][nc] = -1;
        }
        k += 1;
        k %= 4;
        while (true) {
            r += dir1[k][0];
            c += dir1[k][1];
            if(r >= N || c >= M || r < 0 || c < 0 || copy[r][c] == 6) break;
            if(copy[r][c] == 0) copy[r][c] = -1;
        }
    }

    private static void CCTV2(int r, int c, int k, int[][] copy) {
        int nr = r;
        int nc = c;
        while (true) {
            nr += dir1[k][0];
            nc += dir1[k][1];
            if(nr >= N || nc >= M || nr < 0 || nc < 0 || copy[nr][nc] == 6) break;
            if(copy[nr][nc] == 0) copy[nr][nc] = -1;
        }
        k += 2;
        while (true) {
            r += dir1[k][0];
            c += dir1[k][1];
            if(r >= N || c >= M || r < 0 || c < 0 || copy[r][c] == 6) break;
            if(copy[r][c] == 0) copy[r][c] = -1;
        }
    }

    private static void CCTV1(int r, int c, int k, int[][] copy) {
        while (true) {
            r += dir1[k][0];
            c += dir1[k][1];
            if(r >= N || c >= M || r < 0 || c < 0 || copy[r][c] == 6) break;
            if(copy[r][c] == 0) copy[r][c] = -1;
        }

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
            }
        }
    }
}