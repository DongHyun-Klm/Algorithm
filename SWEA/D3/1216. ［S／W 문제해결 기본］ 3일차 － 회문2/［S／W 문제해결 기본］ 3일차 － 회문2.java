import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받기
		for (int i = 0; i < 10; i++) {
			int T = Integer.parseInt(br.readLine()), cnt = 0, N = 100;
			
				String[] arr = new String[100];

				for (int j = 0; j < 100; j++) {
					arr[j] = br.readLine();
				}
				outer: for (int k = N; k >= 1; k--) {
				// 행 방향 검사
				for (int j = 0; j < 100; j++) {
					for (int j2 = 0; j2 < 100 - k; j2++) {
						StringBuilder sb = new StringBuilder();
						sb.append(arr[j].substring(j2, j2 + k));
						if (sb.toString().equals(sb.reverse().toString())) {
							System.out.printf("#%d %d\n",i+1,k);
							break outer;
						}
					}
				}

				// 배열 90도 회전
				String[] rotatedArr = new String[100];
				for (int j = 0; j < 100; j++) {
					StringBuilder sb = new StringBuilder();
					for (int k2 = 99; k2 >= 0; k2--) {
						sb.append(arr[k2].charAt(j));
					}
					rotatedArr[j] = sb.toString();
				}
				arr = rotatedArr;

				// 다시 검사
				for (int j = 0; j < 100; j++) {
					for (int j2 = 0; j2 < 100 - k; j2++) {
						StringBuilder sb = new StringBuilder();
						sb.append(arr[j].substring(j2, j2 + k));
						if (sb.toString().equals(sb.reverse().toString())) {
							System.out.printf("#%d %d\n",i+1,k);
							break outer;
						}
					}
				}
			}

		}
	}
}
