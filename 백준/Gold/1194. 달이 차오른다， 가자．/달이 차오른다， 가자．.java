import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][][] visited;
	static class node{
		int r, c, dist, key;
		node(int r, int c, int dist, int key) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.key = key;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		arr = new char[N][M];
		visited = new boolean[N][M][100];
		int r = -1, c = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		o: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == '0') {
					r = i; c = j;
					break o;
				}
			}
		}
		BFS(r, c);
	}
	private static void BFS(int r,int c) {
		Queue<node> queue = new LinkedList<>();
		queue.add(new node(r, c, 0, 0));
		visited[r][c][0] = true;
		while (!queue.isEmpty()) {
			node now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				if(nr>=N || nc>=M || nr<0 || nc<0) continue;
				int number = arr[nr][nc];
				if(number == 35) continue;
				// 달
				if(number == 49) {
					System.out.println(now.dist+1);
					return;
				}
				// .
				else if(number==46 || number == 48) {
					if(!visited[nr][nc][now.key]) {
						visited[nr][nc][now.key] = true;
						queue.add(new node(nr, nc, now.dist+1, now.key));
					}
				}
				// 문
				else if(number>=65 && number<=70&&!visited[nr][nc][now.key]) {
					if(((1<<number-65) & now.key) != 0) {
						visited[nr][nc][now.key] = true;
						queue.add(new node(nr, nc, now.dist + 1, now.key));
					}
				}
				// 열쇠
				else if(number>=97&&number<=102) {
					if(visited[nr][nc][now.key]) continue;
					int key = now.key;
					// 키 첫 방문이라면 키 획득
					if((now.key & (1<<number-97)) == 0) {
						key = now.key + (1<<number-97);
					}
					visited[nr][nc][key] = true;
					queue.add(new node(nr, nc, now.dist+1, key));
				}
			}
		}
		System.out.println(-1);
	}
}