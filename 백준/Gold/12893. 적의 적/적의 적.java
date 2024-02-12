import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] al;
    static int N, M;
    static boolean flag;
    static int[] team;

    public static void main(String[] args) throws IOException {
        input();
        flag = true;
        team = new int[N+1];
        for (int i = 1; i <= N; i++) {
            if(team[i] == 0) DFS(i, 1);
        }
        if(flag) System.out.println(1);
        else System.out.println(0);
    }

    private static void DFS(int i, int teamNum) {
        team[i] = teamNum;
        for(int t : al[i]) {
            if(team[t] != 0) {
                if(team[t] == teamNum) {
                    flag = false;
                    return;
                }
            }
            else {
                if(teamNum==1) DFS(t, 2);
                else DFS(t, 1);
            }
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[a].add(b);
            al[b].add(a);
        }
    }
}