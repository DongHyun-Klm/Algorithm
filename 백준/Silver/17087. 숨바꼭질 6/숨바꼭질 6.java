import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		// N = 1만 예외처리하자
		if(N==1) {
			System.out.println(Math.abs(S-Integer.parseInt(st.nextToken())));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
		}
		int gcd = GCD(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			gcd = Math.min(gcd, GCD(arr[i], gcd));
		}
		System.out.println(gcd);
	}
	private static int GCD(int a, int b) {
		if(b==0) return a;
		else {
			return GCD(b, a%b);
		}
	}
}
