import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), count = 0;
        int[][] edge = new int[(N-1) * N / 2][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                if(i<j){
                    edge[count][0] = i;
                    edge[count][1] = j;
                    edge[count++][2] = n;
                }
            }
        }
        Arrays.sort(edge, (a, b) -> a[2] - b[2]);

        p = new int[N+1];
        for(int i=1; i<=N; i++) p[i] = i;

        int pick = 0;
        long ans = 0;
        count = 0;

        while (pick != N-1){
            int r = edge[count][0];
            int c = edge[count][1];
            int w = edge[count][2];
            if(findSet(r) != findSet(c)){
                ans += w;
                pick++;
                union(r, c);
            }
            count++;
        }
        System.out.println(ans);
    }
    static int findSet(int i){
        if(p[i] != i) p[i] = findSet(p[i]);
        return p[i];
    }

    static void union(int i, int j){
        int a = findSet(i);
        int b = findSet(j);
        if(a>b) p[a] = b;
        else p[b] = a;
    }
}