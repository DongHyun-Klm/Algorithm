import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class node implements Comparable<node>{
		int v, dist;
		node(int v, int dist){
			this.v = v;
			this.dist = dist;
		}
		@Override
		public int compareTo(node o) {
			return dist - o.dist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<node>[] arr = new ArrayList[N+1];
		for (int i = 1; i < arr.length; i++) arr[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[x].add(new node(y, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<node> queue = new PriorityQueue<>();
		queue.add(new node(start, 0));
		while (!queue.isEmpty()) {
			node now = queue.poll();
			if(visited[now.v]) continue;
			visited[now.v] = true;
			for(node n : arr[now.v]) {
				if(now.dist + n.dist < dist[n.v]) {
					dist[n.v] = now.dist + n.dist;
					queue.add(new node(n.v, dist[n.v]));
				}
			}
		}
		System.out.println(dist[target]);
	}
}