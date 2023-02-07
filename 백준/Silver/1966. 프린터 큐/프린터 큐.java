
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt(), index = sc.nextInt();
			Queue<Integer> queue = new LinkedList<Integer>();
			Queue<Integer> cnt = new LinkedList<Integer>();

			for (int j = 0; j < N; j++) {
				int a = sc.nextInt();
				queue.add(a);
				cnt.add(j);
			}

			int count = 1;
			while (!queue.isEmpty()) {
				if (queue.peek() == Collections.max(queue)) {
					queue.poll();
					if (cnt.poll() == index)
						System.out.println(count++);
					else
						count++;
				} else {
					queue.add(queue.poll());
					cnt.add(cnt.poll());
				}
			}
		}
	}
}
