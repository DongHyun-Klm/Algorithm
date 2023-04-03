import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			DFS(i);
			for (int j = 1; j < visited.length; j++) {
				if(visited[j]) System.out.print("1" + ' ');
				else System.out.print("0" + ' ');
			}
			System.out.println();
		}
	}
	private static void DFS(int i) {
		for (int j = 1; j <= N; j++) {
			if (arr[i][j]==1 && !visited[j]) {
				visited[j] = true;
				DFS(j);
			} 
		}
		
	}

}