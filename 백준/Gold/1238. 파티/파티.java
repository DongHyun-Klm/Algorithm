import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X;
	static ArrayList<info>[] arr;
	static class info implements Comparable<info>{
		int v, weight;
		info(int v, int weight){
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(info o) {
			return weight - o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		ArrayList<info>[] arr_reverse = new ArrayList[N+1];
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
			arr_reverse[i] = new ArrayList<>();
		}
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x =	 Integer.parseInt(st.nextToken());
			int y =	 Integer.parseInt(st.nextToken());
			int m =  Integer.parseInt(st.nextToken());
			arr[x].add(new info(y, m));
			arr_reverse[y].add(new info(x, m));
		}
		int[] dist = new int[N+1];
		int[] dist2 = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(dist2, Integer.MAX_VALUE);
		dist[X] = 0; dist2[X] = 0;
		boolean[] visited = new boolean[N+1];
		PriorityQueue<info> q = new PriorityQueue<>();
		q.add(new info(X, 0));
		while (!q.isEmpty()) {
			info now = q.poll();
			if(visited[now.v]) continue;
			visited[now.v] = true;
			for(info t : arr[now.v]) {
				if(dist[t.v] > t.weight + dist[now.v]) {
					dist[t.v] = t.weight + dist[now.v];
					q.add(new info(t.v, dist[t.v]));
				}
			}
		}
		Arrays.fill(visited, false);
		q.add(new info(X, 0));
		while (!q.isEmpty()) {
			info now = q.poll();
			if(visited[now.v]) continue;
			visited[now.v] = true;
			for(info t : arr_reverse[now.v]) {
				if(dist2[t.v] > t.weight + dist2[now.v]) {
					dist2[t.v] = t.weight + dist2[now.v];
					q.add(new info(t.v, dist2[t.v]));
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dist[i] + dist2[i]);
		}
		System.out.println(max);
	}
}