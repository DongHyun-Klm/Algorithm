import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] operator = new int[4];
	static char[] selected;
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static Map<Integer, Character> map = new HashMap<Integer, Character>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		selected = new char[N];
		map.put(0, '+');
		map.put(1, '-');
		map.put(2, '*');
		map.put(3, '/');
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < operator.length; i++) {
			operator[i] = sc.nextInt();
		}
		rec_fun(1);
		System.out.println(max);
		System.out.println(min);
	}

	private static void rec_fun(int d) {
		if (d == arr.length) {
			int num = arr[0];
			for (int i = 1; i < arr.length; i++) {
				switch (selected[i]) {
				case '+':
					num += arr[i];
					break;
				case '-':
					num -= arr[i];
					break;
				case '*':
					num *= arr[i];
					break;
				case '/':
					num /= arr[i];
					break;
				}
			}
			max = Math.max(num, max);
			min = Math.min(num, min);
		} else {
			for (int i = 0; i < 4; i++) {
				if (operator[i] > 0) {
					operator[i]--;
					selected[d] = map.get(i);
					rec_fun(d + 1);
					operator[i]++;
				}
			}
		}
	}
}