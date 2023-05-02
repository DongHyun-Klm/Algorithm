import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
			if(n==0&&k==0) break;
			int[] arr = new int[n+1];
			int[] p = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
			p[0] = -1; p[1] = 0;
			int index = 1, kIndex = -1;
			for (int i = 2; i < p.length; i++, index++) {
				for(; i< p.length; i++) {
					p[i] = index;
					if(i!=n && arr[i] + 1 != arr[i+1]) break;
				}
			}
			for(int i=1;i<=n;i++) 
				if(arr[i] == k) {
					kIndex = p[i];
					break;
				}
			int ans = 0;
			for (int i = 1; i < p.length; i++) {
				if(p[p[i]] == p[kIndex] && p[i] != kIndex) ans++;
			}
			System.out.println(ans);
		}
	}
}