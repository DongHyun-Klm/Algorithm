import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static double from_x, from_y, to_x, to_y;
    static int N;
    static double[][] arr;
    static ArrayList<edge>[] al;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class edge {
        int v;
        double w;

        public edge(int v, double w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        double[] time = new double[N+1];
        Arrays.fill(time, 10000);
        time[1] = 0;
        PriorityQueue<edge> pq = new PriorityQueue<>((a, b) -> (int) (a.w - b.w));
        pq.add(new edge(1, 0));
        while (!pq.isEmpty()) {
            edge now = pq.poll();
            if(time[now.v] != now.w) continue;
            for(edge e : al[now.v]) {
                if(time[e.v] > time[now.v] + e.w) {
                    time[e.v] = time[now.v] + e.w;
                    pq.add(new edge(e.v, time[e.v]));
                }
            }
        }
        System.out.println(time[N]);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        from_x = Double.parseDouble(st.nextToken()); from_y = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        to_x = Double.parseDouble(st.nextToken()); to_y = Double.parseDouble(st.nextToken());
        N = Integer.parseInt(br.readLine()) + 2;
        al = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList<>();
        arr = new double[N+1][2];
        arr[1][0] = from_x;
        arr[1][1] = from_y;
        arr[N][0] = to_x;
        arr[N][1] = to_y;
        for (int i = 2; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) continue;
                // 각 노드간 걸리는 최소 시간 구하기
                double dist = Math.sqrt(Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2));
                double time = dist / 5.0;
                if(i != 1)time = Math.min(time, Math.abs(dist - 50) / 5.0 + 2);
                al[i].add(new edge(j, time));
            }
        }
    }
}