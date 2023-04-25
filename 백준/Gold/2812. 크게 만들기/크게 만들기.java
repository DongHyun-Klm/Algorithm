import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(), K = sc.nextInt();
		Stack<Integer> stk = new Stack<>();
		char[] arr = sc.next().toCharArray();
		for (int i = 0; i < N; i++) {
			while (!stk.isEmpty() && K > 0 && (int) arr[i] - '0' > stk.peek()) {
				stk.pop();
				K--;
			}
			stk.add(arr[i] - '0');
		}
		while (K>0) {
			stk.pop();
			K--;
		}
		while (!stk.isEmpty()) {
			sb.insert(0, stk.pop());
		}
		System.out.println(sb.toString());
	}
}