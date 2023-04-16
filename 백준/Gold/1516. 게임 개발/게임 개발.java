import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	static class node{
		int v, time;
		node(int v, int time){
			this.v = v;
			this.time = time;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		int[] time = new int[N+1];
		int[] dp = new int[N+1];
		int[] degree = new int[N+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			time[i] = sc.nextInt();
			while (true) {
				int x = sc.nextInt();
				if(x==-1) break;
				arr[x].add(i);
				degree[i]++;
			}
		}
		Queue<node> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(degree[i]==0) {
				q.add(new node(i, time[i]));
				dp[i] = time[i];
			}
		}
		while (!q.isEmpty()) {
			node now = q.poll();
			for (int n : arr[now.v]) {
				degree[n]--;
				dp[n] = Math.max(dp[n], now.time);
				if(degree[n]==0) {
					dp[n] += time[n];
					q.add(new node(n, dp[n]));
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(dp[i]);
		}
	}
}