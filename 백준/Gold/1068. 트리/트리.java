import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] arr;
	static int[] dp;
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), root=-1;
		arr = new ArrayList[N];
		visited = new boolean[N];
		dp = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < arr.length; i++) {
			int x = sc.nextInt();
			if(x==-1) {
				root = i;
				continue;
			}
			arr[x].add(i);
		}
		int del = sc.nextInt();
		for (int i = 0; i < N; i++) {
			if(arr[i].contains(del)) {
				arr[i].remove(arr[i].indexOf(del));
			}
		}
		DFS(root);
		if(del == root) System.out.println(0);
		else System.out.println(cnt);
	}
	private static void DFS(int root) {
		visited[root] = true;
		for (int t : arr[root]) {
			if(!visited[t])
			DFS(t);
		}
		if(arr[root].size()==0) {
			cnt++;
		}
	}
}