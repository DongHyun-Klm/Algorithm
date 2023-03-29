import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 0;
		visited = new boolean[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u].add(v);
			arr[v].add(u);
		}
		for (int i = 1; i < arr.length; i++) {
			if (!visited[i]) {
				BFS(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < arr[x].size(); i++) {
				if(visited[arr[x].get(i)]) continue;
				queue.add(arr[x].get(i));
				visited[arr[x].get(i)] = true;
			}
		}
	}
}