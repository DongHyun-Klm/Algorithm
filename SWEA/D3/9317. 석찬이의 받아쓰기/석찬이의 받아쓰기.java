import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt(), cnt = 0;
			char[] arr = new char[N];
			char[] arr2 = new char[N];
			String s = sc.next();
			String s2 = sc.next();
			arr=s.toCharArray();
			arr2=s2.toCharArray();
			for (int j = 0; j < arr2.length; j++) {
				if(arr[j]==arr2[j]) cnt++;
			}
			System.out.printf("#%d %d\n",i+1,cnt);
		}
	}
}
