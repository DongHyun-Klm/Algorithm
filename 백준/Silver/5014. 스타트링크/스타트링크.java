import java.io.*;
import java.util.*;

public class Main {
    static int F, G, S, U, D;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[F + 1];
        q.add(new int[]{S, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == G) {
                System.out.println(now[1]);
                return;
            }
            if(now[0] + U <= F && !visit[now[0] + U]) {
                q.add(new int[]{now[0] + U, now[1] + 1});
                visit[now[0] + U] = true;
            }
            if(now[0] - D >= 1 && !visit[now[0] - D]) {
                q.add(new int[]{now[0] - D, now[1] + 1});
                visit[now[0] - D] = true;
            }
        }
        System.out.println("use the stairs");
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
    }
}