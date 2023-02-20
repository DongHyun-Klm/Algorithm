import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int[] cnt = new int[4];
			char[] arr = s.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				int n = arr[i];
				if(n>=97&&n<=122) {
					cnt[0]++;
				}
				else if (n>=65&&n<=90) {
					cnt[1]++;
				}
				else if (n>=48&&n<=57) {
					cnt[2]++;
				}
				else cnt[3]++;
			}
			System.out.println(Arrays.toString(cnt).replaceAll("[\\[\\],]", ""));
		}
	}
}
