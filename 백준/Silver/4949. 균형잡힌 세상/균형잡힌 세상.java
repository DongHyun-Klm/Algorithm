
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String s = sc.nextLine();
			if (s.equals("."))
				break;
			else {
				Stack<Character> stk = new Stack<>();
				char[] arr = new char[s.length()];
				arr = s.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == '[' || arr[i]== '(') {
						stk.add(arr[i]);
					} 
					else if (arr[i] == ')') {
						if(stk.isEmpty())stk.add(arr[i]);
						else if (stk.peek()!='(') {
							stk.add(arr[i]);
						}
						else {
							stk.pop();
						}
					}
					else if (arr[i] == ']') {
						if(stk.isEmpty())stk.add(arr[i]);
						else if (stk.peek()!='[') {
							stk.add(arr[i]);
						}
						else {
							stk.pop();
						}
					}
						

				}
				if(stk.isEmpty())System.out.println("yes");
				else System.out.println("no");
			}
		}
	}
}