import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		int[] number = new int[N];
		Stack<Double> stk = new Stack<>();
		for (int i = 0; i < number.length; i++) {
			number[i] = sc.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			int a = (int) arr[i];
			if(a>=65&&a<=90) {
				stk.add((double) number[a-65]);
			}
			else {
				switch (arr[i]) {
				case '+':
					double n2 = stk.pop();
					double n1 = stk.pop();
					stk.add(n1+n2);
					break;
				case '-':
					n2 = stk.pop();
					n1 = stk.pop();
					stk.add(n1-n2);
					break;
				case '*':
					n2 = stk.pop();
					n1 = stk.pop();
					stk.add(n1*n2);
					break;
				case '/':
					n2 = stk.pop();
					n1 = stk.pop();
					stk.add(n1/n2);
					break;
				}
			}
		}
		System.out.printf("%.2f",stk.pop());
	}
}
