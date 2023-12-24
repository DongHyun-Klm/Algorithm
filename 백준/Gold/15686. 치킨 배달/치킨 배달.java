import java.util.*;

public class Main {
	static ArrayList<int[]> chkicken = new ArrayList<>();
	static ArrayList<int[]> house = new ArrayList<>();
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static int N, M, answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		int[][] arr = new int[N][N];
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==2) chkicken.add(new int[] {i, j});
				else if(arr[i][j]==1) house.add(new int[] {i, j});
			}
		}
		BT(0, 0, map);
		System.out.println(answer);
	}
	private static void BT(int d, int start, int[][] map) {
		if(d == M) {
			answer = Math.min(answer, BFS(map));
			return;
		}
		for (int i = start; i < chkicken.size(); i++) {
			map[chkicken.get(i)[0]][chkicken.get(i)[1]] = 2;
			BT(d+1, i+1, map);
			map[chkicken.get(i)[0]][chkicken.get(i)[1]] = 0;
		}
	}
	
	private static int BFS(int[][] arr) {
		int dis = 0;
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < house.size(); i++) {
			boolean[][] visited = new boolean[N][N];
			q.clear();
			q.add(new int[] {house.get(i)[0], house.get(i)[1], 0});
			visited[house.get(i)[0]][house.get(i)[1]] = true;
			o:
				while(!q.isEmpty()) {
					int[] now = q.poll();
					for (int j = 0; j < 4; j++) {
						int nr = now[0] + dir[j][0];
						int nc = now[1] + dir[j][1];
						if(nr<0||nc<0||nr>=N||nc>=N) continue;
						if(visited[nr][nc]) continue;
						if(arr[nr][nc] == 2) {
							dis += now[2] + 1;
							break o;
						}
						q.add(new int[] {nr, nc, now[2]+1 });
						visited[nr][nc] = true;
					}
				}
		}
		return dis;
	}
}