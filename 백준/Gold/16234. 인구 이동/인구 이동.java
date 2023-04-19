import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, L, R, cnt = 0;
	static int[][] arr;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static ArrayList<Integer> li;
	static Queue<Integer> q;
	static boolean[][] visited;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); L = sc.nextInt(); R = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		li = new ArrayList<>();
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		
		while (true) {
			flag = false;
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						li.clear();
						q.clear();
						DFS(i,j);
						if(li.size()==1) continue;
						int popul = 0;
						for(int t : li) popul += t;
						popul /= li.size();
						while (!q.isEmpty()) {
							arr[q.poll()][q.poll()] = popul;
						}
					}
				}
			}
			if(flag) ans++;
			else break;
		}
		System.out.println(ans);
	}
	private static void DFS(int r, int c) {
		visited[r][c] = true;
		li.add(arr[r][c]);
		q.add(r); q.add(c);
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr<0||nc<0||nr>=N||nc>=N) continue;
			if(visited[nr][nc]) continue;
			if(Math.abs(arr[r][c]-arr[nr][nc]) >= L && Math.abs(arr[r][c]-arr[nr][nc]) <= R) {
				flag = true;
				DFS(nr,nc);
			}
		}
	}
}