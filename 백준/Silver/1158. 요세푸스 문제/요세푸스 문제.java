
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(),K = sc.nextInt();
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		int[] arr = new int[N];
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			arr[cnt++] = queue.poll();
			
		}
		System.out.print("<");
		System.out.print(Arrays.toString(arr).replaceAll("[\\[\\]]", ""));
		System.out.print(">");
		System.out.println();
	}
}
