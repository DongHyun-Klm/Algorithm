import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] nums, selected;
	static int N, min, max, count, len;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt(), cnt = 0;
		int[] trouble = new int[M];
		for (int i = 0; i < M; i++) {
			trouble[i] = sc.nextInt();
		}
		Arrays.sort(trouble);
		nums = new int[10 - M];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		// N의 자리수 len
		len = Integer.toString(N).length();
		// 고장난 애들 빼고 배열에 추가
		for (int i = 0; i < 10; i++) {
			if (Arrays.binarySearch(trouble, i) < 0) {
				nums[cnt++] = i;
			}
		}
		// 수를 조합하여 N보다 큰 최소 찾기
		for (int i : nums) {
			fun_min(i, 1);
		}
		int min_count = Integer.toString(min).length();
		min_count += Math.abs(min - N);
		if(min == Integer.MAX_VALUE) min_count = Integer.MAX_VALUE;
		// 수를 조합하여 N보다 작은 최대 찾기
		for (int i : nums) {
			fun_max(i, 1);
		}
		int max_count = Integer.toString(max).length();
		max_count += Math.abs(N - max);
		if(max == Integer.MIN_VALUE) max_count = Integer.MAX_VALUE;
		// 그냥 움직였을때 몇번걸리나 확인
		fun_count(100);
		// 이중 최소를 출력
		System.out.println(Math.min(min_count, Math.min(max_count, count)));
	}

	private static void fun_count(int now) {
		count = Math.abs(N - now);
	}

	private static void fun_max(int now, int d) {
		if (d == len) {
			if (now > N)
				return;
			else if (max < now)
				max = now;
		} else {
			for (int i = nums.length - 1; i >= 0; i--) {
				fun_max(now * 10 + nums[i], d + 1);
				if (max < now)
					max = now;
			}
		}
	}

	private static void fun_min(int now, int d) {
		if (d == len + 1) {
				if (now < N)
					return;
				if (min > now)
					min = now;
		} else {
			if (d == len) {
				if (now >= N && min > now)
					min = now;
			}
			for (int i = nums.length - 1; i >= 0; i--) {
				fun_min(now * 10 + nums[i], d + 1);
			}
		}
	}

}