import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// dp1[n]은 n까지의 증가 수열 최대 길이
		int[] dp1 = new int[N];
		// 초기값 
		Arrays.fill(dp1, 1);
		// dp1 구하기
		for (int i = 1; i < dp1.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j])dp1[i] = Math.max(dp1[j]+1, dp1[i]);
			}
		}
		// dp2[n]은 n까지 증가 수열이고 그 뒤는 감소 수열일 때 감소 수열 최대 길이
		int[] dp2 = new int[N];
		// 초기값
//		Arrays.fill(dp2, 1);
		// dp2 구하기
		for (int i = dp1.length-1; i >= 0; i--) {
			for (int j = N-1; j > i; j--) {
				if(arr[i]>arr[j])dp2[i] = Math.max(dp2[j]+1, dp2[i]);
			}
		}
	
		// dp1 dp2 합의 최대
		for (int i = 0; i < dp2.length; i++) {
			dp1[i] += dp2[i];
		}
		
		System.out.println(Arrays.stream(dp1).max().getAsInt());
	}
}