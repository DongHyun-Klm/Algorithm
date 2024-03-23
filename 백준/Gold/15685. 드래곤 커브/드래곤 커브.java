import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<Integer> al = new ArrayList<>();
    static int[][] dir = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
    static boolean[][] visit = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragon(y,x,d,g);
            al.clear();
        }
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(visit[i][j] && visit[i+1][j] && visit[i][j+1] && visit[i+1][j+1])
                    ans++;
            }
        }
        System.out.println(ans);


    }

    private static void dragon(int r, int c, int d, int g) {
        al.add(d);
        visit[r][c] = true;
        for (int i = 1; i <= g; i++) {
            int size = al.size();
            for (int j = size-1; j >= 0; j--) {
                al.add((al.get(j) + 1) % 4);
            }
        }

        for (int t : al) {
            r += dir[t][0];
            c += dir[t][1];
            visit[r][c] = true;
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

    }
}