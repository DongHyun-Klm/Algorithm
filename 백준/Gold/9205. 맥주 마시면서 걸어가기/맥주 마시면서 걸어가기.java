import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class info{
		int r, c;
		info(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		o:
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int home_r = sc.nextInt(), home_c = sc.nextInt();
			int[][] store = new int[n][2];
			boolean[] visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				store[i][0] = sc.nextInt();
				store[i][1] = sc.nextInt();
			}
			int fev_r = sc.nextInt(), fev_c = sc.nextInt();
			Queue<info> q = new LinkedList<>();
			q.add(new info(home_r, home_c));
			while (!q.isEmpty()) {
				info now = q.poll();
				if(Math.abs(now.r - fev_r) + Math.abs(now.c - fev_c) <= 1000) {
					System.out.println("happy");
					continue o;
				}
				for (int i = 0; i < n; i++) {
					if(visited[i]) continue;
					if(Math.abs(now.r - store[i][0]) + Math.abs(now.c - store[i][1]) <= 1000) {
						q.add(new info(store[i][0], store[i][1]));
						visited[i] = true;
					}
				}
			}
			System.out.println("sad");
		}
	}
}