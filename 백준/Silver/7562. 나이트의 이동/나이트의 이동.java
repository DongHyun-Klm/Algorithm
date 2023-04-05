import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] dir = { {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1,-2}, {-1,-2}, {-2,-1} };
	static int l,de_r,de_c;
	static int[][] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			l = sc.nextInt();
			int r = sc.nextInt(), c = sc.nextInt();
			de_r = sc.nextInt(); de_c = sc.nextInt();
			dist = new int[l][l];
			BFS(r, c);
			System.out.println(dist[de_r][de_c]);
		}
	}
	private static void BFS(int r, int c) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(r); queue.add(c);
		while(!queue.isEmpty()) {
			int y = queue.poll();
			int x = queue.poll();
			for (int k = 0; k < 8; k++) {
				int nr = y + dir[k][0];
				int nc = x + dir[k][1];
				if(nr>=0&&nc>=0&&nr<l&&nc<l&&dist[nr][nc]==0) {
					if(nr==r && nc==c) continue;
					dist[nr][nc] = dist[y][x] + 1;
					if(nr== de_r && nc == de_c) break;
					queue.add(nr); queue.add(nc);
				}
			}
		}
	}
}