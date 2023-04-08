import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class node implements Comparable<node>{
		int v, dist;
		node(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
		@Override
		public int compareTo(node o) {
			return dist - o.dist;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		ArrayList<node>[] arr = new ArrayList[N+1];
		for(int i=1;i<=N;i++) arr[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			arr[x].add(new node(y, w));
			arr[y].add(new node(x, w));
		}
		boolean[] visited = new boolean[N+1];
		PriorityQueue<node> queue = new PriorityQueue<>();
		int pick = 0, ans = 0;
		visited[1] = true;
		for(node x : arr[1]) {
			queue.add(x);
		}
		while(pick!=N-1) {
			node now = queue.poll();
			if(visited[now.v]) continue;
			ans += now.dist;
			pick++;
			visited[now.v] = true;
			for(node x : arr[now.v]) {
				queue.add(x);
			}
		}
		System.out.println(ans);
	}
}