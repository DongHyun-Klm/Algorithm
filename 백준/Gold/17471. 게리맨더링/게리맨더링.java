import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, min;
	static int[] popul;
	static ArrayList<Integer>[] arr;
	static ArrayList<Integer> group1 = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new ArrayList[N + 1];
		popul = new int[N + 1];
		min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			popul[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			int size = sc.nextInt();
			for (int j = 0; j < size; j++) {
				int x = sc.nextInt();
				arr[i].add(x);
			}
		}
		// 1 ~ N/2개 고르기
		for (int i = 1; i <= N / 2; i++) {
			select(0, 1, i);
		}
		if (min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
	}

	private static void select(int d, int start, int lim) {
		if (d == lim) {
			ArrayList<Integer> group2 = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (!group1.contains(i))
					group2.add(i);
			}
			// 그룹끼리 인접해있는지 확인하기
			if (group1.size() > 1)
				if (!chk(group1))
					return;
			if (group2.size() > 1)
				if (!chk(group2))
					return;
			// 인구수 차이 구하기
			int pop1 = 0;
			int pop2 = 0;
			for (int i : group1) {
				pop1 += popul[i];
			}
			for (int i : group2) {
				pop2 += popul[i];
			}
			min = Math.min(Math.abs(pop1 - pop2), min);
			return;
		}
		for (int i = start; i <= N; i++) {
			group1.add(i);
			select(d + 1, i + 1, lim);
			group1.remove(d);
		}
	}

	private static boolean chk(ArrayList<Integer> group) {
			Queue<Integer> queue = new LinkedList<>();
			boolean[] connect = new boolean[N + 1];
			connect[group.get(0)] = true;
			queue.add(group.get(0));
			while (!queue.isEmpty()) {
				int n = queue.poll();
				for (int n2 : arr[n]) {
					if (group.contains(n2)&&!connect[n2]) {
						connect[n2] = true;
						queue.add(n2);
					}
				}
			}
			for (int cnt : group) {
				if (!connect[cnt])
					return false;
			}
		return true;
	}
}