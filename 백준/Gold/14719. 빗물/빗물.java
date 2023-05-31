import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(), W = sc.nextInt();
		boolean[][] block = new boolean[H][W];
		for (int i = 0; i < W; i++) {
			int x = sc.nextInt();
			for (int j = 1; j <= x; j++) {
				block[H-j][i] = true;
			}
		}
		int ans = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(block[i][j]) continue;
				int left = j-1, right = j+1;
				while (left>=0) {
					if(block[i][left]) break;
					left--;
				}
				while (right<W) {
					if(block[i][right]) break;
					right++;
				}
				if(left!=-1 && right!=W) ans++;
			}
		}
		System.out.println(ans);
	}
}
