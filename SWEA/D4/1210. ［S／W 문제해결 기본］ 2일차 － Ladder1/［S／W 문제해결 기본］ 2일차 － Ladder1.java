import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[102][102];
		int t = 10;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken()), start = -1;
			// 사다리 입력 받기
			for (int i = 100; i >= 1; i--) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < arr.length-1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 시작점 2 찾기
			for (int i = 0; i < arr.length; i++) {
				if (arr[1][i] == 2) {
					start = i;
					break;
				}
			}
			//이동
			int row = 1, colum = start;
			boolean flag1 = false, flag2 = false;
			while (row!=100) {
				if(arr[row][colum+1]==0&&arr[row][colum-1]==0) {
					row +=1;
					flag1 = false;
					flag2 = false;
				}
				else if(arr[row][colum+1]==1 && flag2==false) {
					colum += 1;
					flag1 = true;
				}
				else if(arr[row][colum-1]==1 && flag1==false){
					colum -= 1;
					flag2 = true;
				}
				else row++;
			}
			System.out.printf("#%d %d\n",tc,colum-1);
			
			
		}
	}
}
