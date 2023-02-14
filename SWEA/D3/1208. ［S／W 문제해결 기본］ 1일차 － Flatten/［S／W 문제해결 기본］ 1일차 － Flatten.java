import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 0; tc < 10; tc++) {
		int[] cnt = new int[101];
		int top=0,down=0;
		
		int dump = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 100; i++) {
			cnt[Integer.parseInt(st.nextToken())]++;
		}

		while(dump>0) {
			dump--;
			for (int i = 100; i > 0; i--) {
				if(cnt[i]>0) {
					cnt[i]--;
					cnt[i-1]++;
					if(cnt[i]==0)top=i-1;
					else top=i;
					break;
				}
			}
			for (int i = 1; i < 101; i++) {
				if(cnt[i]>0) {
					cnt[i]--;
					cnt[i+1]++;
					if(cnt[i]==0)down=i+1;
					else down=i;
					break;
				}
			}
			if(top-down<2)break;
		}
		System.out.printf("#%d %d\n",tc+1,top-down);
		}
	}
}
