import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int N = sc.nextInt();
			char[] arr = sc.next().toCharArray();
			Stack<Character> stk = new Stack<>();
			for (int j = 0; j < arr.length; j++) {
				if (!stk.isEmpty()) {
					if (arr[j] == stk.peek()) {
						stk.pop();
						continue;
					}
					} 
				stk.add(arr[j]);
			}
			System.out.print("#"+(i+1)+" ");
			System.out.println(stk.toString().replaceAll("[\\[\\], ]",""));
		}
	}
}
