import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class node implements Comparable<node>{
		int v, weight;
		public node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(node o) {
			return weight - o.weight;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<node>[] arr = new ArrayList[N+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int weight = sc.nextInt();
			arr[x].add(new node(y, weight));
			arr[y].add(new node(x, weight));
		}
		
		PriorityQueue<node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		// 하나 넣기
		visited[1] = true;
		queue.addAll(arr[1]);
		int ans = 0;
		int pick = 1;
		int max = 0;
		while(pick != N) {
			node e = queue.poll();
			if(visited[e.v]) continue;
			ans += e.weight;
			max = Math.max(max, e.weight);
			visited[e.v] = true;
			pick++;
			queue.addAll(arr[e.v]);
		}
		System.out.println(ans - max);
	}
}