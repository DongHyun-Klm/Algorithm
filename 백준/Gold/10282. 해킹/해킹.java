import java.io.*;
import java.util.*;

public class Main {
    static int n, d, c;
    static ArrayList<info>[] al;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class info {
        int v, w;
        public info(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            int cnt = 0, max = -1;
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;
            PriorityQueue<info> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
            pq.add(new info(c, 0));
            while (!pq.isEmpty()) {
                info now = pq.poll();
                if(dist[now.v] < now.w) continue;
                for(info f : al[now.v]) {
                    if(dist[f.v] > dist[now.v] + f.w) {
                        dist[f.v] = dist[now.v] + f.w;
                        pq.add(new info(f.v, dist[f.v]));
                    }
                }
            }
            for (int j = 1; j <= n; j++) {
                if(dist[j] != Integer.MAX_VALUE) {
                    cnt++;
                    max = Math.max(max, dist[j]);
                }
            }
            System.out.println(cnt + " " + max);
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); d = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        al = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) al[i] = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            al[b].add(new info(a, s));
        }
    }
}