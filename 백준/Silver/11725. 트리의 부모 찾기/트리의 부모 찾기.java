import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] P;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		P = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		BFS(1);
		for (int i = 2; i <= N; i++) {
			sb.append(P[i]).append('\n');
		}
		System.out.println(sb.toString());
	}
	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.add(start);
		while (!queue.isEmpty()) {
			int x = queue.poll();
			
			for (int i = 0; i < arr[x].size(); i++) {
				if(visited[arr[x].get(i)]) continue;
				queue.add(arr[x].get(i));
				visited[arr[x].get(i)] = true;
				P[arr[x].get(i)] = x;
			}
		}
	}
}