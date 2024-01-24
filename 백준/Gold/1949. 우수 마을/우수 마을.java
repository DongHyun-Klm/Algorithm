import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static ArrayList<Integer>[] al;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        int[][] dp = new int[N + 1][2];
        DFS(1, 0, dp);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void DFS(int i, int pre, int[][] dp) {

        for(int t : al[i]){
            if(t == pre) continue;
            DFS(t, i, dp);
            dp[i][0] += Math.max(dp[t][0], dp[t][1]);
            dp[i][1] += dp[t][0];
        }
        dp[i][1] += people[i];
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        people = new int[N+1];
        al = new ArrayList[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < people.length; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) al[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
            al[n1].add(n2);
            al[n2].add(n1);
        }
    }
}