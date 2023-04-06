import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n+1];
		arr = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x].add(y);
			arr[y].add(x);
		}
		visited[1] = true;
		DFS(1,0);
		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			if(visited[i]) cnt++;
		}
		System.out.println(cnt);
	}
	private static void DFS(int start, int d) {
		if(d==2) return;
		for (int i = 0; i < arr[start].size(); i++) {
			visited[arr[start].get(i)] = true;
			DFS(arr[start].get(i), d+1);
		}
	}
}