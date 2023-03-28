import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, M, V;
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		arr = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(arr[i]);
		}
		DFS(V);
		System.out.println(sb.toString());
		sb = new StringBuilder(); Arrays.fill(visited, false);
		BFS(V);
		System.out.println(sb.toString());
	}
	// DFS 탐색
	private static void DFS(int v) {
		visited[v] = true;
		sb.append(v).append(' ');
		for (int i = 0; i < arr[v].size(); i++) {
			if(visited[arr[v].get(i)]) continue;
			DFS(arr[v].get(i));
		}
	}
	// BFS 탐색
	private static void BFS(int v) {
		queue.add(v);
		visited[v] = true;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			sb.append(x).append(' ');
			for (int i = 0; i < arr[x].size(); i++) {
				if(visited[arr[x].get(i)]) continue;
				queue.add(arr[x].get(i));
				visited[arr[x].get(i)] = true;
			}
		}
	}

}