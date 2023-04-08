import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean flag = true;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		Sudoku();
	}
	private static void Sudoku() {
		if(flag&&complete()) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			flag = false;
			return;
		}
		if(!flag) return;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(arr[i][j] == 0) {
					for (int j2 = 1; j2 <= 9; j2++) {
						  if (chk(i, j, j2)) {
		                        arr[i][j] = j2;
		                        Sudoku();
		                        arr[i][j] = 0;
		                    }
						  if(j2==9) return;
					}
				}
			}
		}
	}
	// 스도쿠에 넣어도 되는 숫자인지 검사
	private static boolean chk(int row, int col, int num) {
		// 가로 검사
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == num) return false;
		}
		// 세로 검사
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == num) return false;
		}
		// 3x3 정사각형 검사
		int r = (row / 3) * 3;
		int c = (col / 3) * 3;
		for (int i = r; i < r + 3; i++) {
		    for (int j = c; j < c + 3; j++) {
		        if (arr[i][j] == num) return false;
		    }
		}
		return true;
	}
	
	// 스도쿠 완성인지 검사
	private static boolean complete() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(arr[i][j]==0) return false; 
			}
		}
		return true;
	}
}