import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deque = new LinkedList<Integer>();
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		while (deque.size()!=1) {
			deque.poll();
			deque.addLast(deque.poll());
		}
		System.out.println(deque.poll());
	}
}
