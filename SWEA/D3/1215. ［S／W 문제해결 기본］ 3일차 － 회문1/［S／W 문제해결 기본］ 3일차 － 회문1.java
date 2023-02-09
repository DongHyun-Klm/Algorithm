import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력 받기
		for (int i = 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine()), cnt=0;
			String[] arr = new String[8];
			for (int j = 0; j < 8; j++) {
				arr[j] = br.readLine();
			}

			// 행 방향 검사
			for (int j = 0; j < 8; j++) {
				for (int j2 = 0; j2 <= 8-N; j2++) {
					StringBuilder sb = new StringBuilder();
					sb.append(arr[j].substring(j2, j2+N));
					if(sb.toString().equals(sb.reverse().toString())) cnt++;
				}
			}
			// 배열 90도 회전
			String[] rotatedArr = new String[8];
			for (int j = 0; j < 8; j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 7; k >= 0; k--) {
					sb.append(arr[k].charAt(j));
				}
				rotatedArr[j] = sb.toString();
			}
			arr = rotatedArr;
			
			// 다시 검사
			for (int j = 0; j < 8; j++) {
				for (int j2 = 0; j2 <= 8-N; j2++) {
					StringBuilder sb = new StringBuilder();
					sb.append(arr[j].substring(j2, j2+N));
					if(sb.toString().equals(sb.reverse().toString())) cnt++;
				}
			}
			System.out.printf("#%d %d\n",i+1,cnt);
		}
	}
}
