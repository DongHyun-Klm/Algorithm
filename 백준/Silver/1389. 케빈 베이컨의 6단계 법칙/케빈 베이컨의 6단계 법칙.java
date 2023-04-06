import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static int[][] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		arr = new ArrayList[N+1];
		count = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x].add(y);
			arr[y].add(x);
		}
		for (int i = 1; i <= N; i++) {
			BFS(i);
		}
		int min = Integer.MAX_VALUE, index = -1;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += count[i][j];
			}
			if(min>sum) {
				min = sum;
				index = i;
			}
		}
		System.out.println(index);
	}
	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < arr[now].size(); i++) {
				if(visited[arr[now].get(i)]) continue;
				visited[arr[now].get(i)] = true;
				count[start][arr[now].get(i)] = count[start][now] + 1;
				queue.add(arr[now].get(i));
			}
		}
	}
}