import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] al;
    static boolean[] visited;
    static boolean cycle;

    public static void main(String[] args) throws IOException {
        int count = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n==0 && m==0) break;
            int T = 0;
            al = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) al[i] = new ArrayList<>();
            input(m);
            Set<Integer> s = new HashSet<>();
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    cycle = false;
                    s.clear();
                    DFS(i, 0, s);
                    if(!cycle) T++;
                }
            }
            if(T==0) sb.append("Case ").append(count++).append(": No trees.").append('\n');
            else if(T==1) sb.append("Case ").append(count++).append(": There is one tree.").append('\n');
            else sb.append("Case ").append(count++).append(": A forest of ").append(T).append(" trees.").append('\n');
        }
        System.out.println(sb);
    }

    private static void DFS(int i, int p, Set<Integer> s) {
        visited[i] = true;
        s.add(i);
        for(int t : al[i]) {
            if(t == p) continue;
            if(!s.contains(t)) DFS(t, i, s);
            else cycle = true;
        }
    }

    private static void input(int m) throws IOException {
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[a].add(b);
            al[b].add(a);
        }
    }
}