import java.io.*;
import java.util.*;

public class Main {
    static int N, M, from, to;
    static ArrayList<edge>[] al;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class edge {
        int v, w;
        public edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[from] = 0;
        PriorityQueue<edge> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        pq.add(new edge(from, 0));
        while (!pq.isEmpty()) {
            edge now = pq.poll();
            // 낡은 정보는 버린다
            if(dist[now.v] != now.w) continue;
            for(edge e : al[now.v]) {
                if(dist[e.v] > dist[now.v] + e.w) {
                    dist[e.v] = dist[now.v] + e.w;
                    pq.add(new edge(e.v, dist[e.v]));
                }
            }
        }
        System.out.println(dist[to]);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        al = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            al[a].add(new edge(b, w));
        }
        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());
    }
}