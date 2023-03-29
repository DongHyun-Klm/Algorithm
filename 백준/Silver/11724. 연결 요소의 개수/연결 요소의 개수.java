import java.util.ArrayList;
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
				DFS(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void DFS(int v) {
		visited[v] = true;
		for (int j = 0; j < arr[v].size(); j++) {
			if(!visited[arr[v].get(j)]) DFS(arr[v].get(j));
		}
	}
}