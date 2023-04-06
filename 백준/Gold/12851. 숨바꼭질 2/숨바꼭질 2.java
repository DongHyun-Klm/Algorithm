import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K, cnt = 0;
	static class node{
		int x, dist;
		node(int x, int dist){
			this.x = x;
			this.dist = dist;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		BFS();
	}
	private static void BFS() {
		Queue<node> queue = new LinkedList<>();
		int[] visited = new int[100001];
		queue.add(new node(N, 0));
		visited[N] = 0;
		int fast = Integer.MAX_VALUE;
		int cnt = 0;
		Arrays.fill(visited, Integer.MAX_VALUE);
		while (!queue.isEmpty()) {
			node now = queue.poll();
			if(now.x == K) {
				if(cnt == 0) {
					fast = now.dist;
					cnt++;
				}
				else {
					if(now.dist == fast) cnt++;
				}
			}
			// + 1
			if(now.x < 100000 && now.dist < visited[now.x+1]) {
				visited[now.x+1] = now.dist + 1;
				queue.add(new node(now.x+1, now.dist+1));
			}
			// - 1
			if(now.x > 0 && now.dist < visited[now.x-1]) {
				visited[now.x-1] = now.dist + 1;
				queue.add(new node(now.x-1, now.dist+1));
			}
			// * 2
			if(2 * now.x <= 100000 && now.dist < visited[now.x*2]) {
				visited[now.x * 2] = now.dist + 1;
				queue.add(new node(now.x * 2, now.dist+1));
			}
		}
		System.out.println(fast);
		System.out.println(cnt);
	}
}