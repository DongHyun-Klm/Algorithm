import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class info{
		int y, v;
		info(int y, int v){
			this.y = y;
			this.v = v;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		int[][] bupum = new int[N+1][N+1];
		ArrayList<info>[] edge = new ArrayList[N+1];
		int[] cnt = new int[N+1];
		for(int i=1;i<=N;i++) edge[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
			cnt[X]++;
			edge[Y].add(new info(X, K));
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) 
			if(cnt[i]==0) {
				q.add(i);
				bupum[i][i] = 1;
			}
		while (!q.isEmpty()) {
			int now = q.poll();
			for(info i : edge[now]) {
				cnt[i.y]--;
				for(int j=1;j<=N;j++) bupum[i.y][j] += bupum[now][j] * i.v; 
				if(cnt[i.y]==0) {
					q.add(i.y);
				}
			}
		}
		for(int i=1;i<=N;i++) 
			if(bupum[N][i]!=0) System.out.println(i + " " + bupum[N][i]);
	} 
}