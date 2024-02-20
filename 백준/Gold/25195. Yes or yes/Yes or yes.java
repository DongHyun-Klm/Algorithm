import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Integer>[] al;
    static Set<Integer> gomgom = new HashSet<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        input();
        DFS(1);
        if (flag) System.out.println("yes");
        else System.out.println("Yes");
    }

    private static void DFS(int v) {
        if(gomgom.contains(v)) return;
        if(al[v].isEmpty()) flag = true;
        for(int t : al[v]) {
            DFS(t);
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        al = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            al[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        int S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            gomgom.add(Integer.parseInt(st.nextToken()));
        }
    }
}