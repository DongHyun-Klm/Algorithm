import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Map<Character, Character> map = new HashMap<>();
		map.put('b', 'd');
		map.put('d', 'b');
		map.put('p', 'q');
		map.put('q', 'p');
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			char[] arr = sc.next().toCharArray();
			for (int i = arr.length-1; i >= 0; i--) {
				sb.append(map.get(arr[i]));
			}
			System.out.println(sb.toString());
		}
	}
}