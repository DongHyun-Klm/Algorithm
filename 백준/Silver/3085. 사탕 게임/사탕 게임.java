import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][N];
		for (int i = 0; i < arr.length; i++) {
			String s = sc.next();
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		// 사탕의 최대 개수
		int max = 0;
		// 00 부터 오른쪽, 아래 검사 + 문제 잘못읽고 풀어서 그냥 왼쪽 위에도 검사하자 
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// 오른쪽 검사
				int c = j;
				int count = 1;
				boolean flag = false;
				while (c != N - 1) {
					c++;
					// 같다면 count++
					if (arr[i][j] == arr[i][c]) {
						count++;
					}
					// 다르다면
					else {
						// 아직 끌어온적 없는경우
						// 위나 아래에 끌어올게 있는지 찾아본다 + 오른쪽도 봐야함 문제좀 잘 읽자 
						if (!flag) {
							int r1 = i + 1;
							int r2 = i - 1;
							int c1 = c+1;
							if (r1 >= 0 && r1 < N) {
								if (arr[i][j] == arr[r1][c]) {
									count++;
									flag = true;
									continue;
								}
							}
							if (r2 >= 0 && r2 < N) {
								if (arr[i][j] == arr[r2][c]) {
									count++;
									flag = true;
									continue;
								}
							}
							if (c1 >= 0 && c1 < N) {
								if (arr[i][j] == arr[i][c1]) {
									count++;
									flag = true;
									break;
								}
							}
							break;
						} else
							break;
					}
				}
				max = Math.max(max, count);
				// 아래쪽 검사
				int r = i;
				count = 1;
				flag = false;
				while (r != N - 1) {
					r++;
					// 같다면 count++
					if (arr[i][j] == arr[r][j]) {
						count++;
					}
					// 다르다면
					else {
						// 아직 끌어온적 없는경우
						// 위나 아래에 끌어올게 있는지 찾아본다
						if (!flag) {
							int c1 = j + 1;
							int c2 = j - 1;
							int r1 = r +1 ;
							if (c1 >= 0 && c1 < N) {
								if (arr[i][j] == arr[r][c1]) {
									count++;
									flag = true;
									continue;
								}
							}
							if (c2 >= 0 && c2 < N) {
								if (arr[i][j] == arr[r][c2]) {
									count++;
									flag = true;
									continue;
								}
							}
							if (r1 >= 0 && r1 < N) {
								if (arr[i][j] == arr[r1][c]) {
									count++;
									flag = true;
									break;
								}
							}
							break;
						} else
							break;
					}
				}
				max = Math.max(max, count);
				// 왼쪽 검사
				c = j;
				count = 1;
				flag = false;
				while (c != 0) {
					c--;
					// 같다면 count++
					if (arr[i][j] == arr[i][c]) {
						count++;
					}
					// 다르다면
					else {
						// 아직 끌어온적 없는경우
						// 위나 아래에 끌어올게 있는지 찾아본다
						if (!flag) {
							int r1 = i + 1;
							int r2 = i - 1;
							int c1 = c -1;
							if (r1 >= 0 && r1 < N) {
								if (arr[i][j] == arr[r1][c]) {
									count++;
									flag = true;
									continue;
								}
							}
							if (r2 >= 0 && r2 < N) {
								if (arr[i][j] == arr[r2][c]) {
									count++;
									flag = true;
									continue;
								}
							}
							if (c1 >= 0 && c1 < N) {
								if (arr[i][j] == arr[i][c1]) {
									count++;
									flag = true;
									break;
								}
							}
							break;
						} else
							break;
					}
				}
				max = Math.max(max, count);
				// 위쪽 검사
				r = i;
				count = 1;
				flag = false;
				while (r != 0) {
					r--;
					// 같다면 count++
					if (arr[i][j] == arr[r][j]) {
						count++;
					}
					// 다르다면
					else {
						// 아직 끌어온적 없는경우
						// 위나 아래에 끌어올게 있는지 찾아본다
						if (!flag) {
							int c1 = j + 1;
							int c2 = j - 1;
							int r1 = r-1;
							if (c1 >= 0 && c1 < N) {
								if (arr[i][j] == arr[r][c1]) {
									count++;
									flag = true;
									continue;
								}
							}
							if (c2 >= 0 && c2 < N) {
								if (arr[i][j] == arr[r][c2]) {
									count++;
									flag = true;
									continue;
								}
							}
							if (r1 >= 0 && r1 < N) {
								if (arr[i][j] == arr[r1][c]) {
									count++;
									flag = true;
									break;
								}
							}
							break;
						} else
							break;
					}
				}
				max = Math.max(max, count);
			}
		}
		System.out.println(max);
	}
}