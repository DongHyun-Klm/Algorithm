import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] dir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	static int l, de_r, de_c;
	static int[][] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt(); 
		int m= sc.nextInt(), r = sc.nextInt()-1, c = sc.nextInt()-1;
		int[][] de = new int[m][2];
		for (int i = 0; i < m; i++) {
			de[i][0] = sc.nextInt();
			de[i][1] = sc.nextInt();
		}
		dist = new int[l][l];
		BFS(r, c);
		for (int i = 0; i < m; i++) {
			System.out.print(dist[de[i][0]-1][de[i][1]-1] + " ");
		}
	}

	private static void BFS(int r, int c) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(r);
		queue.add(c);
		while (!queue.isEmpty()) {
			int y = queue.poll();
			int x = queue.poll();
			for (int k = 0; k < 8; k++) {
				int nr = y + dir[k][0];
				int nc = x + dir[k][1];
				if (nr >= 0 && nc >= 0 && nr < l && nc < l && dist[nr][nc] == 0) {
					if (nr == r && nc == c)
						continue;
					dist[nr][nc] = dist[y][x] + 1;
					queue.add(nr);
					queue.add(nc);
				}
			}
		}
	}
}