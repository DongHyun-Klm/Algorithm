import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int _ = sc.nextInt(), sum = 0;
			int[][] arr = new int[100][100];

			for (int j = 99; j >= 0; j--) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					arr[j][j2] = sc.nextInt();
				}
			}

			for (int j = 0; j < arr.length; j++) {
				Stack<Integer> stk = new Stack<>();
				for (int j2 = 0; j2 < arr.length; j2++) {
					if (stk.isEmpty()) {
						if (arr[j2][j] == 2)
							stk.add(arr[j2][j]);
					}
					else {
						if(arr[j2][j] ==1) {
							stk.pop();
							sum++;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",i+1,sum);
		}
	}
}
