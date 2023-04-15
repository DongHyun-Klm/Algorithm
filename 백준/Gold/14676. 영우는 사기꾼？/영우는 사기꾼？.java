import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		int[] degree = new int[N + 1];
		int[] build = new int[N + 1];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x].add(y);
			degree[y]++;
		}
		boolean flag = true;
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (x == 1) {
				// 현재 생성 가능한지 체크
				if (degree[y] == 0) {
					if (build[y] == 0) {
						for (int t : arr[y]) {
							degree[t]--;
						}
					}
					build[y] += 1;
				} else
					flag = false;
			} else {
				// 건설도 안했는데 부쉈다면
				if (build[y] == 0)
					flag = false;
				build[y] -= 1;
				if (build[y] == 0) {
					for (int t : arr[y]) {
						degree[t]++;
					}
				}
			}
		}
		if (flag)
			System.out.println("King-God-Emperor");
		else
			System.out.println("Lier!");
	}
}