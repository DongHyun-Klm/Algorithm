import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] al;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            // 한놈 먼저 잡고 조상들을 set에 저장
            Set<Integer> s = new HashSet<>();
            s.add(x);
            while (!al[x].isEmpty()) {
                x = al[x].get(0);
                s.add(x);
            }
            // 다른 한놈 올라가면서 조상겹치나 확인
            while (true) {
                if(s.contains(y)) break;
                y = al[y].get(0);
            }
            sb.append(y).append('\n');
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        // 조상 기억할 ArrayList (무조건 1개라 배열로 해도 될듯)
        al = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            al[y].add(x);
        }
    }
}