import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int max = 0;
		ArrayList<Integer> index = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			if (num < 0)
				index.add(i);
		}
		// dp[n]은 n까지의 연속된 수를 선택한 경우중 합이 가장 큰 경우
		int[] dp = new int[n];
		// 초기값
		dp[0] = arr[0];
		// dp[n] 구하기
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
		}
		max = Arrays.stream(dp).max().getAsInt();
		// dp2[n]은 n까지의 연속된 수를 선택한 경우중 합이 가장 큰 경우 > 거꾸로 출발
		int[] dp2 = new int[n];
		// 초기값
		dp2[n - 1] = arr[n - 1];
		// dp2[n]구하기
		for (int i = n - 2; i >= 0; i--) {
			dp2[i] = Math.max(arr[i], dp2[i + 1] + arr[i]);
		}

		// 음수 index를 하나씩 0으로 해서 최대값 찾기
		for (int d = 0; d < index.size(); d++) {
			if (index.get(d) > 0 && index.get(d) < n - 1) {
				int max2 = dp[index.get(d) - 1] + dp2[index.get(d) + 1];
				max = Math.max(max, max2);
			}
		}
		System.out.println(max);
	}
}