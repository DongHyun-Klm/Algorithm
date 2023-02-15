import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			String s = sc.next();
			char[] arr = new char[s.length()];
			Set<Integer> set = new HashSet<>();
			arr = s.toCharArray();
			for (char c : arr) {
				set.add((int)c-48);
			}
			System.out.printf("#%d %d\n",i+1,set.size());
		}
	}
}
