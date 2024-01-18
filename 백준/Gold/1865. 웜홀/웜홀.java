import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, W;
    static ArrayList<info>[] al;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class info {
        int v, w;
        public info(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            input();
            int[] dist = new int[N+1];
            Arrays.fill(dist, 987654321);
            boolean cycle = false;
            // 시작점 1로잡자
            dist[1] = 0;
            // 총 N번 반복 (N번째에 값 변하면 음수 사이클 있음)
            for (int j = 0; j < N; j++) {
                // 매번 모든 간선 확인
                for (int k = 1; k <= N; k++) {
                    for(info info : al[k]) {
                        if(dist[info.v] > dist[k] + info.w) {
                            dist[info.v] = dist[k] + info.w;
                            if(j == N-1) cycle = true;
                        }
                    }
                }
            }
            if(cycle) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        al = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            al[s].add(new info(e, t));
            al[e].add(new info(s, t));
        }
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            al[s].add(new info(e, -t));
        }
    }
}