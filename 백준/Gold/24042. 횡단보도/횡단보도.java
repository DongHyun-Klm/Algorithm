import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<info>[] al;
    static class info {
        int v;
        long time;

        public info(int v, long time) {
            this.v = v;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<info> pq = new PriorityQueue<>((a, b) -> {
            return (int) (a.time - b.time);
        });
        pq.add(new info(1,0));
        while (!pq.isEmpty()) {
            info now = pq.poll();
            if(dist[now.v] < now.time) continue;
            for(info f : al[now.v]) {
                long nowTime = now.time % M;
                long time = f.time - nowTime;
                if(time < 0) time += M;
                if(dist[f.v] > now.time + time) {
                    dist[f.v] = now.time + time;
                    pq.add(new info(f.v, now.time + time));
                }
            }
        }
        System.out.println(dist[N]);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        al = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[a].add(new info(b, i+1));
            al[b].add(new info(a, i+1));
        }
    }
}