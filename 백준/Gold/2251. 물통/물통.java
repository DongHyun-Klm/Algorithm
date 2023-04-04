import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node {
		int A, B, C;
		public node(int a, int b, int c) {
			this.A = a;
			this.B = b;
			this.C = c;
		}
		node move(int from, int to, node n) {
			int[] X = new int[3];
			X[0] = n.A;
			X[1] = n.B;
			X[2] = n.C;
			if(bot[to] < X[from] + X[to]) {
				X[from] -= (bot[to] - X[to]);
				X[to] = bot[to];
			}
			else {
				X[to] += X[from];
				X[from] = 0;
			}
			return new node(X[0], X[1], X[2]);
		}
	}
	static int[] bot;
	static boolean[][][] visited;
	static boolean[] possible;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		bot = new int[3];
		for (int i = 0; i < bot.length; i++) {
			bot[i] = sc.nextInt();
		}
		visited = new boolean[201][201][201];
		possible = new boolean[201];
		BFS();
		for (int i = 0; i <= bot[2]; i++) {
			if(possible[i]) System.out.print(i+" ");
		}
	}
	private static void BFS() {
		Queue<node> queue = new LinkedList<>();
		queue.add(new node(0, 0, bot[2]));
		visited[0][0][bot[2]] = true;
		while (!queue.isEmpty()) {
			node n = queue.poll();
			if(n.A == 0) possible[n.C] = true;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==j) continue;
					node d = n.move(i, j, n);
					if(!visited[d.A][d.B][d.C]) {
						queue.add(d);
						visited[d.A][d.B][d.C] = true;
					}
				}
			}
		}
	}
}