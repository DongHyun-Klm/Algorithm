import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int N = sc.nextInt(), M = sc.nextInt();
			String[] arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next();
			}
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("0001101", 0);map.put("0011001", 1);map.put("0010011", 2);
			map.put("0111101", 3);map.put("0100011", 4);map.put("0110001", 5);
			map.put("0101111", 6);map.put("0111011", 7);map.put("0110111", 8);
			map.put("0001011", 9);
			// 암호 해독 담을 스택
			Stack<Integer> stack = new Stack<>();
			boolean flag = false;
			// 8개씩 뒤에서 부터 끊어 읽기
			for (int i = 0; i < N; i++) {
				for (int j = M-1; j >= 0; j--) {
					if(arr[i].charAt(j) == '1') {
						stack.add(map.get(arr[i].substring(j-6 , j+1)));
						j -= 6;
						flag = true;
					}
				}
				if(flag) break;
			}
			int even = 0, odd = 0, len = stack.size();
			for (int i = 0; i < len; i++) {
				// 홀수 자리
				if(i%2 == 0) odd += stack.pop();
				else even += stack.pop();
			}
			if((odd * 3 + even) % 10 != 0) System.out.printf("#%d %d\n",tc,0);
			else System.out.printf("#%d %d\n",tc,odd+even);
		}
	}
}
