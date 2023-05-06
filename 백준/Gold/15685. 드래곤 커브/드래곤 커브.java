import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static boolean[][] visited = new boolean[101][101];
	static int [][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
	static ArrayList<Integer> dirray = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-->0) {
			int c = sc.nextInt(), r = sc.nextInt(), d = sc.nextInt(), g = sc.nextInt();
			dirray.clear();
			dragon(r,c,d,g);
		}
		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1])
					ans++;
			}
		}
		System.out.println(ans);
	}
	private static void dragon(int r, int c, int d, int g) {
		dirray.add(d);
		visited[r][c] = true;
		for (int i = 1; i <= g; i++) {
			int size = dirray.size();
			for (int j = size-1; j >= 0; j--) {
				dirray.add((dirray.get(j)+1)%4);
			}
		}
		for(int t : dirray) {
			r = r + dir[t][0];
			c = c + dir[t][1];
			visited[r][c] = true;
		}
	}
}