import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, x = -1, max = -1;
    static ArrayList<int[]>[] al;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();
        visit = new boolean[N+1];
        visit[1] = true;
        DFS(1, 0);
        max = 0;
        visit = new boolean[N+1];
        visit[x] = true;
        DFS(x, 0);
        System.out.println(max);
    }

    private static void DFS(int v, int sum) {
        for(int[] t : al[v]) {
            if(visit[t[0]]) continue;
            visit[t[0]] = true;
            DFS(t[0], sum + t[1]);
        }
        if(sum > max) {
            x = v;
            max = sum;
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        al = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            al[n1].add(new int[] {n2, v});
            al[n2].add(new int[] {n1, v});
        }
    }
}