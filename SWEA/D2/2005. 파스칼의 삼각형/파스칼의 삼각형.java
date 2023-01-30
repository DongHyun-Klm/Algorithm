import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int[] arr = new int[10];
			int n = sc.nextInt();
			System.out.printf("#%d\n",i);
			for (int j = 0; j < n; j++) {
				if(j==0) arr[0] = 1;
				if(j==1) arr[1] = 1;
				else {
					int[] sub = Arrays.copyOf(arr, 10);
					for (int j2 = 1; j2 < j; j2++) {
						arr[j2]=sub[j2-1]+sub[j2];
					}
				}
				arr[j]=1;
				for (int j2 = 0; j2 < j+1; j2++) {
					System.out.print(arr[j2]+" ");
				}
				System.out.println();
			}
		}
	}
}