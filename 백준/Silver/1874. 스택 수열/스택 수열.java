

import java.util.Scanner;
import java.util.Stack;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 1;
		boolean flag = true;
		Stack<Integer> stk = new Stack<>();
		StringBuilder bild = new StringBuilder();
		

		for (int i = 0; i < n; i++) {
			int number = sc.nextInt();
			while(stk.isEmpty() || number != stk.peek() ) {
				if (cnt > number) {
					flag = false;
					break;
				}
				stk.add(cnt);
				cnt++;
				bild.append("+").append("\n");
			}
			if (!flag) {
				System.out.println("NO");
				break;
			}
			stk.pop();
			bild.append("-").append("\n");
		}
		if (flag) {
			System.out.println(bild);
		}
	}

}
