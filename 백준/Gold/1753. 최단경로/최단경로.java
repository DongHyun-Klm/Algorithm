import java.awt.Event;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int INF = Integer.MAX_VALUE;
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int index = Integer.parseInt(br.readLine());
		ArrayList<node>[] arr = new ArrayList[V+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[x].add(new node(y, weight));
		}
		PriorityQueue<node> queue = new PriorityQueue<>();
		boolean[] visitied = new boolean[V+1];
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		queue.add(new node(index, 0));
		dist[index] = 0;
		while (!queue.isEmpty()) {
			node e = queue.poll();
			if(visitied[e.v]) continue;
			visitied[e.v] = true;
			for (int i = 0; i < arr[e.v].size(); i++) {
				node d = arr[e.v].get(i);
				if(!visitied[d.v] && dist[d.v] > dist[e.v] + d.weight) {
					dist[d.v] = dist[e.v] + d.weight;
					queue.add(new node(d.v, dist[d.v]));
				}
			}
		}
		for (int i = 1; i < dist.length; i++) {
			if(visitied[i]) System.out.println(dist[i]);
			else System.out.println("INF");
		}
	}
}