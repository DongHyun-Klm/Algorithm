import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[1001][1001];
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int x1 = sc.nextInt(), y1 = sc.nextInt();
			int x2 = sc.nextInt(), y2 = sc.nextInt();
			for (int j = x1; j < x1+x2; j++) {
				for (int j2 = y1; j2 < y1+y2; j2++) {
					arr[j][j2] = i;
				}
			}
		}
		int[] area = new int[n];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					if(arr[j][j2]==i)area[i-1] += 1; 
				}
			}
		}
		for (int i = 0; i < area.length; i++) {
			System.out.println(area[i]);
		}
	}
}