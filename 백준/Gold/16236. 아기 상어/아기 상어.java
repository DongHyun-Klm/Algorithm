import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static class node{
		int r, c, dist, size;
		public node(int r, int c, int dist, int size) {
			this.c = c;
			this.r = r;
			this.dist = dist;
			this.size = size;
		}
		@Override
		public String toString() {
			return "node [r=" + r + ", c=" + c + ", dist=" + dist + ", size=" + size + "]";
		}
	}
	static class food{
		int r, c, dist, size;
		public food(int r, int c, int dist, int size) {
			this.c = c;
			this.r = r;
			this.dist = dist;
			this.size = size;
		}
		@Override
		public String toString() {
			return "food [r=" + r + ", c=" + c + ", dist=" + dist + ", size=" + size + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int shark_r = -1, shark_c = -1, shark_size = 2, shark_cnt = 2, ans=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==9) {
					shark_r = i;
					shark_c = j;
					arr[i][j] = 0;
				}
			}
		}
		Queue<node> q = new LinkedList<>();
		PriorityQueue<food> fish = new PriorityQueue<>(new Comparator<food>() {
			@Override
			public int compare(food o1, food o2) {
				if(o1.dist != o2.dist) return o1.dist - o2.dist;
				if(o1.r!=o2.r) return o1.r - o2.r;
				return o1.c - o2.c;
			}
		});
		while (true) {
		q.add(new node(shark_r, shark_c, 0, shark_size));
		visited[shark_r][shark_c] = true;
		// 먹이 찾기
		while (!q.isEmpty()) {
			node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				if(nr<0||nc<0||nr>=N||nc>=N) continue;
				if(visited[nr][nc]) continue;
				if(arr[nr][nc] == 0 || arr[nr][nc] == now.size) {
					visited[nr][nc] = true;
					q.add(new node(nr, nc, now.dist+1, now.size));
				}
				else if(arr[nr][nc] < now.size) {
					visited[nr][nc] = true;
					fish.add(new food(nr, nc, now.dist+1 ,arr[nr][nc]));
				}
			}
		}
		if(fish.isEmpty()) break;
		// 먹이 먹기
		food eat = fish.poll();
		arr[eat.r][eat.c] = 0;
		shark_r = eat.r;
		shark_c = eat.c;
		shark_cnt--;
		ans += eat.dist;
		if(shark_cnt==0) {
			shark_size++;
			shark_cnt = shark_size;
		}
		q.clear();
		fish.clear();
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
		}
		System.out.println(ans);
	}
}