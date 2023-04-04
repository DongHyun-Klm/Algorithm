import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static boolean[] visited;
	static int[] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		visited = new boolean[100001];
		dist = new int[100001];
		N = sc.nextInt();
		K = sc.nextInt();
		BFS();
		System.out.println(dist[K]);
	}
	private static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visited[N] = true;
		while (!queue.isEmpty()) {
			int n = queue.poll();
			if(n==K) break;
			if(n < 100000 && !visited[n+1]) {
				queue.add(n+1);
				dist[n+1] = dist[n] + 1;
				visited[n+1] = true;
			}
			if(n>0 && !visited[n-1]) {
				queue.add(n-1);
				dist[n-1] = dist[n] + 1;
				visited[n-1] = true;
			}
			if(2*n < 100001 && !visited[2*n]) {
				queue.add(2*n);
				dist[2*n] = dist[n] + 1;
				visited[2*n] = true;
			}
		}
	}
}