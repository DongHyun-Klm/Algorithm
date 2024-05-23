import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, Q;
    static ArrayList<info>[] al;
    static boolean[] visit;
    static class info {
        int v, r;
        public info(int v, int r) {
            this.v = v;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int[] USADO = new int[N+1];
            visit = new boolean[N + 1];
            DFS(v, Integer.MAX_VALUE, USADO);
            int count = 0;
            for (int i = 1; i <= N; i++) if(USADO[i] >=k) count++;
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    private static void DFS(int v, int min, int[] USADO) {
        visit[v] = true;
        for (info t : al[v]) {
            if(visit[t.v]) continue;
            USADO[t.v] = Math.min(min, t.r);
            DFS(t.v, Math.min(min, t.r), USADO);
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        al = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            al[n1].add(new info(n2, r));
            al[n2].add(new info(n1, r));
        }
    }
}