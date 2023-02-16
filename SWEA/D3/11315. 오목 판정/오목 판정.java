import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int N = sc.nextInt();
			boolean flag = false;
			int[][] arr = new int[N][N];
			String[] s = new String[N];
            
//			오목판 받기
			for (int j = 0; j < N; j++) {
				s[j] = sc.next();
			}
            
//			01로 바꾸기
			for (int j = 0; j < N; j++) {
				char[] arr2 = s[j].toCharArray();
				for (int k = 0; k < N; k++) {
					if (arr2[k] == 46)
						arr[j][k] = 0;
					else
						arr[j][k] = 1;
				}
			}

			//8방향 탐색
			int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
			int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
            
			//오목 찾기
			outer:
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(arr[j][j2]==1) {
						for (int d = 0; d < 8; d++) {
							int cnt = 1;
							int nr = j + dr[d];
							int nc = j2 + dc[d];
							if(nr>=N||nr<0||nc>=N||nc<0)continue;
							else if(arr[nr][nc]==1){
								cnt++;
								while (cnt!=5) {
									nr += dr[d];
									nc += dc[d];
									if(nr>=N||nr<0||nc>=N||nc<0)break;
									if(arr[nr][nc]==1) {
										cnt++;
									}
									else break;
								}
								if(cnt ==5) {
									flag = true;
									break outer;
								}
							}
						}
					}
				}
			}
			System.out.print("#"+(i+1)+" ");
			if(flag)System.out.printf("YES\n");
			else System.out.printf("NO\n");
		}
	}
}
