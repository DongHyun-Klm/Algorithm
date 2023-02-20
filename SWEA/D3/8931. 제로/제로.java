import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] arr = new int[100000];
	static int top = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			// arr 초기화
			Arrays.fill(arr, 0);
			// top 초기화 
			top = -1;
			int N = sc.nextInt();
			// 액수 부르기
			for (int j = 0; j < N; j++) {
				int money = sc.nextInt();
				// 0이면
				if(money==0) {
					pop();
				}
				// 아니면
				else {
					push(money);
				}
			}
			// 합 출력하기
			int sum = 0;
			for (int j = 0; j <= top; j++) {
				sum += arr[j];
			}
			System.out.printf("#%d %d\n",i+1,sum);
		}
	}

	// push
	static void push(int x) {
		if (isfull()) {
			System.out.println("stackOverFlow");
		} else
			arr[++top] = x;
	}

	// pop
	static int pop() {
		if (isempty()) {
			System.out.println("stack is empty");
			return -1;
		} else {
			return arr[top--];
		}
	}

	// peek
	static int peek() {
		if (isempty()) {
			System.out.println("stack is empty");
			return -1;
		} else
			return arr[top];
	}

	// isempty
	static boolean isempty() {
		return top == -1;
	}

	// isfull
	static boolean isfull() {
		return top == arr.length - 1;
	}
}
