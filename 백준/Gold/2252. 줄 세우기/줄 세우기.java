import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++) arr[i] = new ArrayList<>();
        int[] count = new int[N + 1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            count[y]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++) if(count[i] == 0) {
            q.add(i);
            sb.append(i).append(" ");
        }
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : arr[now]){
                count[i]--;
                if(count[i] == 0) {
                    q.add(i);
                    sb.append(i).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}