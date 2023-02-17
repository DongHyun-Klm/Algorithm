import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int tc = sc.nextInt(), count = 0;
			char[] fs = sc.next().toCharArray();
			char[] ts = sc.next().toCharArray();
			boolean flag;
			
			for (int j = 0; j < ts.length - (fs.length - 1); j++) {
				if (ts[j] == fs[0]) {
					flag = true;
					for (int j2 = 1; j2 < fs.length; j2++) {
						if (ts[j + j2] != fs[j2]) {
							flag = false;
							break;
						}
					}
					if(flag)count++;
				}
			}
			System.out.printf("#%d %d\n", tc, count);
		}
	}
}
