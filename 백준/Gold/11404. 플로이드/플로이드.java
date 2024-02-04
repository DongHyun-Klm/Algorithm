import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, INF = 20000000;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        input();
        // 플로이드 워셜
        int[][] dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) continue;
                else if(arr[i][j] == 0) dist[i][j] = INF;
                else dist[i][j] = arr[i][j];
            }
        }
        // 경유
        for (int i = 1; i <= N; i++) {
            // 출발
            for (int j = 1; j <= N; j++) {
                // 도착
                for (int k = 1; k <= N; k++) {
                    if(dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(dist[i][j] == INF) sb.append(0).append(' ');
                else sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(arr[a][b]!=0) arr[a][b] = Math.min(arr[a][b],w);
            else arr[a][b] = w;
        }
    }
}