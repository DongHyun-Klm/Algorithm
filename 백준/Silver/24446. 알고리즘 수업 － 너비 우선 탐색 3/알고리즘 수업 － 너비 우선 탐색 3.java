import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, R;
	static ArrayList<Integer>[] arr;
	static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt(); R = sc.nextInt();
		arr = new ArrayList[N+1];
		visited = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		BFS(R);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]-1).append('\n');
		}
		System.out.println(sb.toString());
	}
	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = 1;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < arr[x].size(); i++) {
				if(visited[arr[x].get(i)] != 0) continue;
				queue.add(arr[x].get(i));
				visited[arr[x].get(i)] = visited[x]+1;
			}
		}
	}
}