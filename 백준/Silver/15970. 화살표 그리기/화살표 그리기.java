import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), sum = 0;
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < arr.length; i++) {
			int point1 = i, point2 = i;
			int left = -1, right = -1;
			while (true) {
				point1 -= 1;
				point2 += 1;
				if (left == -1 && point1 >= 0 && arr[point1][1] == arr[i][1]) {
					left = arr[i][0] - arr[point1][0];
				}
				if (right == -1 && point2 < N && arr[point2][1] == arr[i][1]) {
					right = arr[point2][0] - arr[i][0];
				}
				if (left == -1 && point1 < 0)
					left = Integer.MAX_VALUE;
				if (right == -1 && point2 > N - 1)
					right = Integer.MAX_VALUE;
				if (left != -1 && right != -1) {
					sum += Math.min(left, right);
					break;
				}
			}
		}
		System.out.println(sum);
	}
}