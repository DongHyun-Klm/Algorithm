import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt(), S = sc.nextInt(), M = sc.nextInt();
		int cnt = 0;
		while (true) {
			int e = cnt % 15 + 1, s = cnt % 28 + 1, m = cnt % 19 + 1;
			if (E == e && S == s && M == m)
				break;
			cnt++;
		}
		System.out.println(cnt+1);
	}
}