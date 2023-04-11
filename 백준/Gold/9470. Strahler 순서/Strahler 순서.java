import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node{
		int v, order;
		node (int v, int order){
			this.v = v;
			this.order = order;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			int M = sc.nextInt(), P = sc.nextInt();
			int[] count = new int[M+1];
			ArrayList<Integer>[] arr = new ArrayList[M+1];
			for (int i = 1; i < arr.length; i++) {
				arr[i] = new ArrayList<>();
			}
			for (int i = 0; i < P; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x].add(y);
				count[y]++;
			}
			Queue<node> queue = new LinkedList<>();
			int[] dist = new int[M+1];
			for (int i = 1; i < count.length; i++) {
				if(count[i]==0) {
					dist[i] = 1;
					for (int n : arr[i]) {
						queue.add(new node(n, 1));
					}
				}
			}
			int[] max = new int[M+1];
			while (!queue.isEmpty()) {
				node now = queue.poll();
				if(now.order==dist[now.v]) {
					max[now.v]++;
				}
				else if(now.order>dist[now.v]) {
					dist[now.v] = now.order;
					max[now.v] = 1;
				}
				count[now.v]--;
				if(count[now.v]==0) {
					if(max[now.v]>1) dist[now.v]++;
					for (int n : arr[now.v]) {
						queue.add(new node(n, dist[now.v]));
					}
				}
			}
			System.out.printf("%d %d\n",K,dist[M]);
		}
	}
}