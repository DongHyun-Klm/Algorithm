import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int N = sc.nextInt();
			sc.nextLine();
			char[] arr = sc.nextLine().toCharArray();
			// 표기식 stack
			Stack<Character> stk = new Stack<>();
			// 연산자 stack
			Stack<Character> stk_oper = new Stack<>();
			// 우선순위 map
			Map<Character, Integer> Priority = new HashMap<>();
			Priority.put('+', 1);
			Priority.put('-', 1);
			Priority.put('/', 2);
			Priority.put('*', 2);

			// 후위 표기식 만들기 시작
			for (int i = 0; i < arr.length; i++) {
				// 숫자라면 push
				if ((int) arr[i] >= 48 && (int) arr[i] <= 57) {
					stk.add(arr[i]);
				}
				// 부호라면
				else {
					// 스택이 비어있다면 push
					if (stk_oper.isEmpty()) {
						stk_oper.add(arr[i]);
					}
					// 스택이 비어있지 않다면
					else {
						// 제일 위의 연산자의 우선순위가 나보다 작아질때까지 혹은 empty까지
						while (!stk_oper.isEmpty() && Priority.get(stk_oper.peek()) >= Priority.get(arr[i])) {
							stk.add(stk_oper.pop());
						}
						// 비교 끝났으면 연산자는 다시 넣기
						stk_oper.add(arr[i]);
					}
				}
			}
			// 남은거 다 넣기
			while (!stk_oper.isEmpty()) {
				stk.add(stk_oper.pop());
			}
			// 표기 끝
		
			// 숫자 담을 stack
			Stack<Integer> number = new Stack<>();
			// 연산 처음부터 시작할 stack
			Stack<Character> operation = new Stack<>();
			while(!stk.isEmpty()) {
				operation.add(stk.pop());
			}
			// 연산 시작
			while (!operation.isEmpty()) {
				char c = operation.pop();
				// 숫자라면 push
				if ((int) c >= 48 && (int) c <= 57) {
					number.add((int)c - 48);
				}
				// 부호라면
				else {
					switch (c) {
					case '+':
						int num2 = number.pop();
						int num1 = number.pop();
						number.add(num1 + num2);
						break;
					case '-':
						num2 = number.pop();
						num1 = number.pop();
						number.add(num1 - num2);
						break;
					case '*':
						num2 = number.pop();
						num1 = number.pop();
						number.add(num1 * num2);
						break;
					case '/':
						num2 = number.pop();
						num1 = number.pop();
						number.add(num1 / num2);
						break;
					}
				}
			}
			System.out.printf("#%d %d\n",tc+1,number.pop());
		}
	}
}
