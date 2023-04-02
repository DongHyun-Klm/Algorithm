import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int mid = sc.nextInt();
			for (int j = start; j <= end; j++) {
				queue.add(arr[j]);
			}
			while (queue.peek()!=arr[mid]) {
				queue.add(queue.poll());
			}
			for (int j = start; j <= end; j++) {
				arr[j] = queue.poll();
			}
		}
		for (int j = 1; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
	}
}