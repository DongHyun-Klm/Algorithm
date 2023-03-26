import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		int[] P = new int[N];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		int[] A = nums.clone();
		Arrays.sort(nums);
		for (int i = 0; i < N; i++) {
			int num = nums[i];
			for (int j = 0; j < N; j++) {
				if(A[j]==num) {
					P[j] = i;
					A[j] = 0;
					break;
				}
				
			}
		}
		System.out.println(Arrays.toString(P).replaceAll("[\\[\\],]", ""));
	}
}