import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] D;
    static int[][] dp;
    static ArrayList<Integer>[] al;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        // 노드 depth, parent 구하기
        init(1, 1, 0);
        // dp[k][v]는 정점 v의 2^k번째 조상 / dp 채우기
        fillParent();
        // 공통 조상 찾기
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            if (D[y] > D[x]) {
                int temp = y;
                y = x;
                x = temp;
            }
            // 높이 맞추기(2^j만큼 차이나면 그만큼 위로 땡기기)
            for (int j = dp.length-1; j >= 0 ; j--) {
                if(Math.pow(2, j) <= D[x] - D[y]) x = dp[j][x];
            }

            // 공통 조상 찾기(멀리있는 부모부터 보는 이유는 멀리있는 부모가 다르다면 그 아래는 볼필요x)
            while (x != y) {
                for (int j = dp.length-1; j >= 0; j--) {
                    if(dp[j][x] != dp[j][y]) {
                        x = dp[j][x];
                        y = dp[j][y];
                    }
                }
                x = dp[0][x];
                y = dp[0][y];
            }
            sb.append(x).append('\n');
        }
        System.out.print(sb);
    }

    private static void fillParent() {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }
    }

    private static void init(int point, int depth, int parent) {
        D[point] = depth;
        dp[0][point] = parent;
        for (int i : al[point]) {
            if(i == parent) continue;
            init(i, depth + 1, point);
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        // 그래프 정보 저장할 al
        al = new ArrayList[N + 1];
        D = new int[N + 1];
        // dp[k][v]는 정점 v의 2^k번째 조상
        // 최대 깊이 k 구하기
        int k = 0, temp = 1;
        while (temp <= N) {
            temp *= 2;
            k++;
        }
        dp = new int[k + 1][N + 1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList();
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            al[x].add(y);
            al[y].add(x);
        }
    }
}