import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), count = 0;
        int M = Integer.parseInt(br.readLine());
        int[][] edge = new int[(N-1) * N / 2][3];
        p = new int[N+1];
        for(int i=1; i<=N; i++) p[i] = i;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int n = Integer.parseInt(st.nextToken());
                if(i<j && n==1){
                    union(i, j);
                }
            }
        }
        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        int chk = findSet(Integer.parseInt(st.nextToken()));
        for(int i=1; i<M; i++){
            if(chk != findSet(Integer.parseInt(st.nextToken()))){
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");

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