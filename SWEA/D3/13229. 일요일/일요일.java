import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("SUN", 7);
		map.put("SAT", 1);
		map.put("FRI", 2);
		map.put("THU", 3);
		map.put("WED", 4);
		map.put("TUE", 5);
		map.put("MON", 6);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			System.out.printf("#%d %d\n",tc+1,map.get(sc.next()));
		}
	}
}
