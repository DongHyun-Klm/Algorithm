import java.util.Scanner;

public class Main {
	static int N, r, c, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); r = sc.nextInt(); c = sc.nextInt();
		cnt = 0;
		find((int)Math.pow(2, N));
	}
	private static void find(int size) {
		if(size == 1) {
			System.out.println(cnt);
		}
		else {
			// 1사분면
			if(r < size/2 && c < size/2) {
				find(size/2);
			}
			// 2사분면
			else if(r < size/2 && c >= size/2) {
				cnt += (size/2)*(size/2) * 1;
				c -= size/2;
				find(size/2);
			}
			// 3사분면
			else if(r >= size/2 && c < size/2) {
				cnt += (size/2)*(size/2) * 2;
				r -= size/2;
				find(size/2);
			}
			// 4사분면
			else {
				cnt += (size/2)*(size/2) * 3;
				r -= size/2; c -= size/2;
				find(size/2);
			}
		}
	}
}