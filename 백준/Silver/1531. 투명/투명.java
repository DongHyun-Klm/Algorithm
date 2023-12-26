import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[101][101];
		int N = sc.nextInt(), M = sc.nextInt();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int x1 = sc.nextInt(), y1 = sc.nextInt();
			int x2 = sc.nextInt(), y2 = sc.nextInt();
			for (int j = x1; j <= x2; j++) {
				for (int k = y1; k <= y2; k++) {
					arr[j][k]++;
					if(arr[j][k] == M + 1) answer++;
				}
			}
		}
		System.out.println(answer);
	}
}