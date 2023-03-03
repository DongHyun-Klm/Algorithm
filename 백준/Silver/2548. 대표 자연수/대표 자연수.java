import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];

		for (int n = 0; n < num; n++) {
			arr[n] = sc.nextInt();
		}
		Arrays.sort(arr);

		int difSum = 0;
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int t = 0; t < arr.length; t++) { // 모든 수를 기준으로
			difSum = 0;
			for (int i = 0; i < arr.length; i++) { // 차이를 비교해서 더해줘요
				difSum += Math.abs(arr[i] - arr[t]);
			}
//			System.out.println(difSum);
			if (min > difSum) { 
				min = difSum;
				minIdx = t;
			}
		}
		System.out.println(arr[minIdx]);
		sc.close();
	}
}