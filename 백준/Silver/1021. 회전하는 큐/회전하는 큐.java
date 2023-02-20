import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		Deque<Integer> deque = new LinkedList<>();
		int[] arr = new int[M];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		for (int i = 0; i < M; i++) {
			int cnt = 0;
			while (deque.peek()!=arr[i]) {
				deque.addLast(deque.pop());
				cnt++;
			}
			
			if(cnt > deque.size()/2) cnt = deque.size()-cnt;
			sum += cnt;
			deque.pop();
		}
		System.out.println(sum);
	}
}
