import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	static int N, K;
	static class node {
		int x, dist;
		node parent;
		node(int x, int dist, node parent) {
			this.x = x;
			this.dist = dist;
			this.parent = parent;
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
		boolean[] visited = new boolean[100001];
		queue.add(new node(N, 0, null));
		visited[N] = true;
		while (!queue.isEmpty()) {
			node now = queue.poll();
			if (now.x == K) {
				System.out.println(now.dist);
				StringBuilder sb = new StringBuilder();
				Stack<Integer> stk = new Stack<>();
				node curr = now;
				while (curr != null) {
					stk.add(curr.x);
					curr = curr.parent;
				}
				while (!stk.isEmpty()) {
					sb.append(stk.pop()).append(' ');
				}
				System.out.println(sb.toString());
				return;
			}
			// + 1
			if (now.x < 100000 && !visited[now.x + 1]) {
				visited[now.x + 1] = true;
				queue.add(new node(now.x + 1, now.dist + 1, now));
			}
			// - 1
			if (now.x > 0 && !visited[now.x - 1]) {
				visited[now.x - 1] = true;
				queue.add(new node(now.x - 1, now.dist + 1, now));
			}
			// * 2
			if (2 * now.x <= 100000 && !visited[now.x * 2]) {
				visited[now.x * 2] = true;
				queue.add(new node(now.x * 2, now.dist + 1, now));
			}
		}
	}
}