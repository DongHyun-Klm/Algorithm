import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
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
		System.out.printf("#%d %d\n",tc,sum);
        }
	}
}
