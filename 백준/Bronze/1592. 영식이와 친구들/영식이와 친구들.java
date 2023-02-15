import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> queue = new LinkedList<>();
		int N = sc.nextInt(), M = sc.nextInt(), L = sc.nextInt(), count = 0;
		int[] cnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		while (true) {
			count++;
			if (cnt[queue.peekFirst()] % 2 == 1) {
				for (int i = 0; i < L; i++) {
					queue.addLast(queue.pollFirst());
				}
				cnt[queue.peekFirst()]++;
				if (cnt[queue.peekFirst()] == M)
					break;
			} else {
				for (int i = 0; i < L; i++) {
					queue.addFirst(queue.pollLast());
				}
				cnt[queue.peekFirst()]++;
				if (cnt[queue.peekFirst()] == M)
					break;
			}
		}
		System.out.println(count-1);
	}
}
