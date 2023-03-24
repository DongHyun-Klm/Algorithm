import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static ArrayList<Character> oper;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] num = s.split("-|\\+");
		nums = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			nums[i] = Integer.parseInt(num[i]);
		}
		String[] o = s.split("1|2|3|4|5|6|7|8|9|0");
		oper = new ArrayList<>();
		for (String s1 : o) {
			if (s1.equals("+"))
				oper.add('+');
			else if (s1.equals("-"))
				oper.add('-');
		}
		int sum = nums[0];
		for (int i = 0; i < oper.size(); i++) {
			if (oper.get(i) == '-') {
				int temp = nums[i + 1];
				i++;
				while (i != oper.size() && oper.get(i) != '-') {
					temp += nums[i + 1];
					i++;
				}
				sum -= temp;
				i--;
			} else {
				sum += nums[i + 1];
			}
		}
		System.out.println(sum);
	}
	// 재귀병에 걸린 나.. 문제부터 읽자
//	private static void findMin(int d) {
//		if(d == nums.length) {
//			int sum = select[0];
//			for (int i = 0; i < oper.size(); i++) {
//				switch (oper.get(i)) {
//				case '+':
//					sum += select[i+1];
//					break;
//
//				default:
//					if(sum > select[i+1]) sum = select[i+1] - sum;
//					else sum -= select[i+1];
//					break;
//				}
//				min = Math.min(sum, min);
//			}
//		}
//		else {
//			for (int i = 0; i < nums.length; i++) {
//				if(chk[i]) continue;
//				select[d] = nums[i];
//				chk[i] = true;
//				findMin(d+1);
//				chk[i] = false;
//			}
//		}
//	}
}