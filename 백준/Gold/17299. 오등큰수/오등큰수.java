import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		Stack<Integer> stk = new Stack<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		int[] cnt = new int[max];
		for (int i : arr) {
			cnt[i-1]++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			while (!stk.isEmpty()&&cnt[arr[stk.peek()]-1]<cnt[arr[i]-1]) {
				arr[stk.pop()] = arr[i];
			}
			stk.push(i);
		}
		while (!stk.isEmpty()) {
			arr[stk.pop()] = -1;
		}
		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
	}
}
