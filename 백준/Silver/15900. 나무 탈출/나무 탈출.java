import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt = 0;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N =  Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i = 1; i<= N; i++) arr[i] = new ArrayList<>();
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		DFS(1, 0);
		if(cnt%2==0) System.out.println("No");
		else System.out.println("Yes");
	}
	private static void DFS(int i, int d) {
		visited[i] = true;
		boolean flag = true;
		for(int x : arr[i]) {
			if(visited[x]) continue;
			DFS(x, d+1);
			flag = false;
		}
		if(flag) {
			cnt += d;
		}
	}
}