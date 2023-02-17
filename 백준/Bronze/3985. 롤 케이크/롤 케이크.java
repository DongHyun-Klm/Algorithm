import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), t = sc.nextInt();
		int[] arr = new int[N + 1], cnt = new int[t];
		int max = Integer.MIN_VALUE, max_num = 0, max_cnt = 0;

		for (int i = 0; i < t; i++) {
			int A = sc.nextInt(), B = sc.nextInt();
			if (B - A != max) {
				max = Math.max(B - A, max);
				if (max == B - A)
					max_num = i + 1;
			}
			for (int j = A; j <= B; j++) {
				if (arr[j] != 0)
					continue;
				else {
					arr[j] = i + 1;
				}
			}
		}

		for (int i : arr) {
			if (i > 0)
				cnt[i - 1]++;
		}
		
		for (int i = 0; i < cnt.length; i++) {
			max_cnt = Math.max(max_cnt, cnt[i]);
		}

		System.out.println(max_num);
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == max_cnt) {
				System.out.println(i + 1);
			break;
			}
		}
	}
}
