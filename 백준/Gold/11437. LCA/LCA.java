import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] D, P;
    static ArrayList<Integer>[] al;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        // 노드 depth, parent 구하기
        init(1, 1, 0);
        // 공통 조상 찾기
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            int dx = D[x], dy = D[y];
            while (dx > dy) {
                x = P[x];
                dx--;
            }
            while (dy > dx) {
                y = P[y];
                dy--;
            }
            while (x != y) {
                x = P[x];
                y = P[y];
            }
            sb.append(x).append('\n');
        }
        System.out.print(sb);
    }

    private static void init(int point, int depth, int parent) {
        D[point] = depth;
        P[point] = parent;
        for (int i : al[point]) {
            if(i == parent) continue;
            init(i, depth + 1, point);
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        // 그래프 정보 저장할 al
        al = new ArrayList[N + 1];
        D = new int[N + 1];
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList();
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            al[x].add(y);
            al[y].add(x);
        }
    }
}