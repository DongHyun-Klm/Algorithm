import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class node{
		int x, time;
		node(int x, int time){
			this.x = x;
			this.time = time;
		}
		@Override
		public String toString() {
			return "node [x=" + x + ", time=" + time + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(), K = sc.nextInt();
			int[] time = new int[N+1];
			int[] c = new int[N+1];
			int[] max = new int[N+1];
			ArrayList<Integer>[] arr = new ArrayList[N+1];
			for (int i = 1; i < arr.length; i++) {
				arr[i] = new ArrayList<>();
			}
			for (int i = 1; i < time.length; i++) {
				time[i] = sc.nextInt();
			}
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x].add(y);
				c[y]++;
			}
			int w = sc.nextInt();
			// 0인 애들 큐에 넣기
			Queue<node> q = new LinkedList<>();
			for (int i = 1; i < c.length; i++) {
				if(c[i]==0) {
					q.add(new node(i, time[i]));
				}
			}
			while (!q.isEmpty()) {
				node now = q.poll();
				if(now.x == w) {
					System.out.println(now.time);
				}
				for(int y : arr[now.x]) {
					c[y]--;
					max[y] = Math.max(max[y], now.time + time[y]);
					if(c[y]==0) {
						q.add(new node(y, max[y]));
					}
				}
			}
		}
	}
}