import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] p;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        rank = new int[N+1];
        for(int i=0; i<=N; i++) {
            p[i] = i;
            rank[i] = 0;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if(option == 0){
                union(a, b);
            } else {
                if(findSet(a) == findSet(b)) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }
        }
        System.out.print(sb);
    }

    private static int findSet(int a) {
        if(p[a] != a) {
            p[a] = findSet(p[a]);
        }
        return p[a];
    }

    private static void union(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if(rootA != rootB) {
            if(rank[rootA] < rank[rootB]) {
                p[rootA] = rootB;
            } else if(rank[rootA] > rank[rootB]) {
                p[rootB] = rootA;
            } else {
                p[rootA] = rootB;
                rank[rootB]++;
            }
        }
    }
}