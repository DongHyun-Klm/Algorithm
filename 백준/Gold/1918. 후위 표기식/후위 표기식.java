import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
		Priority.put('(', 0);

		// 후위 표기식 만들기 시작
		for (int i = 0; i < arr.length; i++) {
			// 숫자라면 push
			if ((int) arr[i] >= 65 && (int) arr[i] <= 90) {
				stk.add(arr[i]);
			}
			// '('라면 추가
			else if (arr[i] == '(') {
				stk_oper.add(arr[i]);
			}
			// ')'라면 '(' 나올때까지 pop
			else if (arr[i] == ')') {
				while (stk_oper.peek() != '(') {
					stk.add(stk_oper.pop());
				}
				// 다했으면 '(' pop
				stk_oper.pop();
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
		System.out.println(stk.toString().replaceAll("[\\[\\], ]", ""));
	}
}
