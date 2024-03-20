import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, E, v1, v2;
    static ArrayList<info>[] al;
    static int[] dist;
    static class info {
        int v, dist;

        public info(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        // v1시작
        dijkstra(v1);
        int v1_1 = dist[1];
        int v1_v2 = dist[v2];
        int v1_N = dist[N];
        // v2시작
        dijkstra(v2);
        int v2_1 = dist[1];
        int v2_N = dist[N];

        long answer = Math.min((long)v1_1 + v1_v2 + v2_N, (long)v2_1 + v1_v2 + v1_N);
        if(answer >= 200000000) answer = -1;

        System.out.println(answer);
    }

    private static void dijkstra(int start) {
        dist = new int[N + 1];
        Arrays.fill(dist, 2000000000);
        dist[start] = 0;
        PriorityQueue<info> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new info(start, 0));
        while (!pq.isEmpty()) {
            info now = pq.poll();
            if(dist[now.v] < now.dist) continue;
            for (info f : al[now.v]) {
                if(dist[f.v] <= f.dist + now.dist) continue;
                dist[f.v] = now.dist + f.dist;
                pq.add(new info(f.v, dist[f.v]));
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        al = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) al[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al[a].add(new info(b, c));
            al[b].add(new info(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
    }
}