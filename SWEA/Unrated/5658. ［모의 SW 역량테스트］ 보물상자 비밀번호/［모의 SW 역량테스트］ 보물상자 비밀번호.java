import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 10);map.put('B', 11);
		map.put('C', 12);map.put('D', 13);
		map.put('E', 14);map.put('F', 15);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); int K = sc.nextInt();
			char[] num = sc.next().toCharArray();
			Deque<Integer> deque = new LinkedList<>();
			// 큐에 16진수 숫자를 10진수로 담아 놓기
			for (int i = 0; i < N; i++) {
				if((int)num[i] >='0' && (int)num[i] <= '9')deque.add(num[i]-'0');
				else deque.add(map.get(num[i]));
			}
			// 생성 가능한 수를 담을 set(중복제거)
			Set<Integer> set = new HashSet<>();
			// 가능한 회전 경우의 수 N/4
			for (int i = 0; i < N/4; i++) {
				// 4방향 각 숫자들을 구하자
				for (int j = 0; j < 4; j++) {
					int sum = 0;
					for (int j2 = N/4; j2 >0 ; j2--) {
						int number = deque.poll();
						sum += Math.pow(16, j2-1) * number;
						deque.addLast(number);
					}
					set.add(sum);
				}
				deque.addLast(deque.poll());
			}
			// set을 다시 배열에 담자
			Integer[] ans = set.toArray(new Integer[0]);
			Arrays.sort(ans);
			System.out.printf("#%d %d\n",tc,ans[set.size()-K]);
		}
	}
}