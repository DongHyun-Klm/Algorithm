import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] slk;
    static int[][] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] curl = new int[K][3];
        arr = new int[N][M];
        slk = new int[K];
        visited = new boolean[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                curl[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        BT(0, curl, K);
        System.out.print(answer);
    }

    // 순열로 회전 연산 순서 뽑기
    private static void BT(int d, int[][] curl, int K) {
        if(d == K) {
            // 회전 연산 순서대로 배열 회전하고 배열값 구하기
            answer = Math.min(answer, rot(curl, K));
            return;
        }
        for (int i = 0; i < K; i++) {
            if(visited[i]) continue;
            slk[d] = i;
            visited[i] = true;
            BT(d+1, curl, K);
            visited[i] = false;
        }
    }

    // 배열 값 구하기
    private static int rot(int[][] curl, int K) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i].clone();
        }
        for (int i = 0; i < K; i++) {
            turn(curl[slk[i]], copy);
        }
        // 최소값 구하기
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum += copy[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    // 배열 회전
    private static void turn(int[] cur, int[][] copy) {
        int r = cur[0] - 1, c = cur[1] - 1, d = cur[2];
        for (int i = 1; i <= d; i++) {
            // 시작점
            int nr = r - i, nc = c - i;
            int last = copy[nr][nc];
            // 윗줄
            for (int j = 0; j < 2 * i; j++) {
                int temp = copy[nr][++nc];
                copy[nr][nc] = last;
                last = temp;
            }
            // 오른쪽줄
            for (int j = 0; j < 2 * i; j++) {
                int temp = copy[++nr][nc];
                copy[nr][nc] = last;
                last = temp;
            }
            // 아래줄
            for (int j = 0; j < 2 * i; j++) {
                int temp = copy[nr][--nc];
                copy[nr][nc] = last;
                last = temp;
            }
            // 왼쪽줄
            for (int j = 0; j < 2 * i; j++) {
                int temp = copy[--nr][nc];
                copy[nr][nc] = last;
                last = temp;
            }
        }
    }
}