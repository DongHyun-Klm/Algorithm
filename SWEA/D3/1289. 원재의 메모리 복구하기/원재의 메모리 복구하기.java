import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			String N = sc.next();
			char[] arr = new char[50];
			arr = N.toCharArray();
			List<Boolean> memorie = new ArrayList<Boolean>();

			for (int j = arr.length-1; j >=0; j--) {
				if (arr[j]=='0') {
					memorie.add(false);
				}
				else {
					memorie.add(true);
				}
			}
			
			int cnt = 0;
			for (int j = memorie.size()-1; j >= 0 ; j--) {
				if(memorie.get(j)==false)continue;
				else {
					cnt++;
					for (int j2 = 0; j2 <= j; j2++) {
						memorie.add(j2, !memorie.get(j2)); 
						memorie.remove(j2+1);
					}
				}
			}
			System.out.printf("#%d %d\n",i,cnt);
		}
	}
}
