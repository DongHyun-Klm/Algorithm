import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int answer;
    static ArrayList<Integer> al = new ArrayList<>();
    static boolean[] visited, finished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            answer = n;
            st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= n; j++) {
                if(visited[j]) continue;
                al.clear();
                DFS(j);
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    private static void DFS(int i) {
        if(finished[i]) return;
        if(visited[i]) {
            answer--;
            finished[i] = true;
        }
        visited[i] = true;
        al.add(i);
        DFS(arr[i]);
        finished[i] = true;
    }
}