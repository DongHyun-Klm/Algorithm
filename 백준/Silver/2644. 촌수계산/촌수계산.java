import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] dist;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new ArrayList[n+1];
		dist = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		int find_x = sc.nextInt(), find_y = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x].add(y);
			arr[y].add(x);
		}
		BFS(find_x, find_y);
		if(dist[find_y]==0) System.out.println(-1);
		else System.out.println(dist[find_y]);
	}
	private static void BFS(int find_x, int find_y) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(find_x);
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < arr[x].size(); i++) {
				if(arr[x].get(i) == find_x) continue;
				if(dist[arr[x].get(i)] == 0) {
					dist[arr[x].get(i)] = dist[x] + 1;
					if(arr[x].get(i) == find_y) return;
					queue.add(arr[x].get(i));
				}
			}
		}
	}
}