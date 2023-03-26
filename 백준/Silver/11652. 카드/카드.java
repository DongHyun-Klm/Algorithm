import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		long num = arr[0], maxNum = arr[0];
		int cnt = 1, max = 0;
		for (int i = 1; i < arr.length; i++) {
			if(num == arr[i]) {
				cnt++;
				if(cnt > max) {
					max = cnt;
					maxNum = num;
				}
			}
			else {
				num = arr[i];
				cnt = 1;
			}
		}
		System.out.println(maxNum);
	}
}