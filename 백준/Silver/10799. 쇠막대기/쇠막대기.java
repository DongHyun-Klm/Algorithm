import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stk = new Stack<>();
		char[] arr = sc.next().toCharArray();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='(')stk.add(arr[i]);
			else {
				if(arr[i-1]=='(') {
					stk.pop();
					sum += stk.size();
				}
				else {
					sum += 1;
					stk.pop();
				}
			}
		}
		System.out.println(sum);
	}
}
