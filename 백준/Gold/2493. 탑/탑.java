import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] answer = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Stack<int[]> s = new Stack<>();

        for(int i=N;i>0;i--){
            if(s.isEmpty()||s.peek()[1]>arr[i]){
                s.add(new int[] {i, arr[i]});
            }
            else{
                while (!s.isEmpty() && s.peek()[1]<arr[i]){
                    int[] now = s.pop();
                    answer[now[0]] = i;
                }
                s.add(new int[] {i, arr[i]});
            }
        }

        for(int i=1;i<=N;i++){
            sb.append(answer[i]).append(' ');
        }
        System.out.print(sb);
    }
}