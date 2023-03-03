import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int row = sc.nextInt(), colum = sc.nextInt();
			sc.nextLine();
			char[][] arr = new char[row][colum];
			// 깃발 받기
			for (int i = 0; i < row; i++) {
				arr[i] = sc.nextLine().toCharArray();
			}
			// 파란색 영역만 정하면 나머지는 정해짐 
			int cnt = 0, min = Integer.MAX_VALUE;
			for (int i = 1; i < row-1; i++) {
				for (int j = i; j < row-1; j++) {
					cnt = 0;
					// 0부터 i까지는 흰색 영역
					for (int j2 = 0; j2 < i; j2++) {
						for (int k = 0; k < colum; k++) {
							if(arr[j2][k] != 'W')cnt++; 
						}
					}
					// i는 파랑영역 시작, j는 파랑영역 끝
					for (int j2 = i; j2 <= j; j2++) {
						for (int k = 0; k < colum; k++) {
							if(arr[j2][k] != 'B')cnt++; 
						}
					}
					// j부터 row-1까지는 빨강영역
					for (int j2 = j+1; j2 < row; j2++) {
						for (int k = 0; k < colum; k++) {
							if(arr[j2][k] != 'R')cnt++; 
						}
					}
					min = Math.min(min, cnt);
				}
			}
			System.out.printf("#%d %d\n",tc,min);
		}
	}
}