import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K, min;
	static int[][] arr, copy;
	static int[] select;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];
			copy = new int[D][W];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = arr[i][j];
				}
			}
			if (inspection(arr))
				System.out.printf("#%d %d\n", tc, 0);
			else {
				for (int i = 1; i <= D; i++) {
					select = new int[i];
					doping(0, i, 0);
					if(min == i) {
						System.out.printf("#%d %d\n", tc, min);
						break;
					}
				}
			}
		}
	}

	// arr배열이 성능 검사를 통과하는지 확인하는 메서드
	private static boolean inspection(int[][] arr) {
		o: for (int i = 0; i < W; i++) {
			int count = 1;
			for (int j = 1; j < D; j++) {
				if (arr[j][i] == arr[j - 1][i])
					count++;
				else
					count = 1;
				if (count == K)
					continue o;
				if (j == D - 1)
					return false;
			}
		}
		return true;
	}

	// arr배열에 N개의 도핑을 하는 메서드
	private static void doping(int d, int N, int start) {
		if (d == N) {
			if(inspection(copy)) min = N;
			return;
		} else {
			for (int i = start; i < D; i++) {
				// 1채우기
				for (int j = 0; j < W; j++) {
					copy[i][j] = 1;
				}
				doping(d + 1, N, i + 1);
				// 2채우기
				for (int j = 0; j < W; j++) {
					copy[i][j] = 0;
				}
				doping(d + 1, N, i + 1);
				// 도핑 복구하기
				for (int j = 0; j < W; j++) {
					copy[i][j] = arr[i][j];
				}
			}
		}
	}
}