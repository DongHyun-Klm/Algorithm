import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), L = sc.nextInt(), ans = 0;
		boolean[] chk = new boolean[1001]; 
		int[] pipe = new int[N];
		for (int i = 0; i < N; i++) {
			pipe[i] = sc.nextInt();
		}
		Arrays.sort(pipe);
		for (int i = 0; i < N; i++) {
			int x = pipe[i];
			if(!chk[x]) {
				for (int j = 0; j < L; j++) {
					if(x+j<=1000)chk[x+j] = true;
				}
				ans++;
			}
		}
		System.out.println(ans);
	}
}