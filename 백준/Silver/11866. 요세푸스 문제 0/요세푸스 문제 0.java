import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		for (int i = 1; i <= N; i++) {
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			for (int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll());
			if (!queue.isEmpty()) {
				sb.append(", ");
			}
		}
		sb.append('>');
		System.out.println(sb);
		sc.close();
	}
}
