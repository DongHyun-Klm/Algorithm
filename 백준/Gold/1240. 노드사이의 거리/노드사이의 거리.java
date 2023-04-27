import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class info{
		int x, dist;
		info(int x, int dist){
			this.x = x;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		ArrayList<info>[] arr = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		for(int i=1; i<=N; i++) arr[i] = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			arr[x].add(new info(y, dist));
			arr[y].add(new info(x, dist));
		}
		for (int i = 0; i < M; i++) {
			Arrays.fill(visited, false);
			Queue<info> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()), n2 =Integer.parseInt(st.nextToken());
			q.add(new info(n1, 0));
			visited[n1] = true;
			o:
			while (!q.isEmpty()) {
				info now = q.poll();
				for (info f : arr[now.x]) {
					if(f.x==n2) {
						sb.append(now.dist+f.dist).append('\n');
						break o;
					}
					if(visited[f.x]) continue;
					q.add(new info(f.x, now.dist+f.dist));
					visited[f.x] = true;
				}
			}
		}
		System.out.println(sb.toString());
	}
}