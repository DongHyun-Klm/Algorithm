import java.util.Scanner;

public class Main {
	static int N, cnt;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); cnt = 0;
		arr = new int[N+2][N+2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 방법의 개수를 찾는 메서드
		search(1,2,1);
		System.out.println(cnt);
	}
	
	private static void search(int r, int c,int status) {
		// 파이프가 벽을 나가면 중단
		if(r>N || c >N) {
			return;
		}
		// 끝이 (N,N)에 도착했다면 cnt++하고 리턴
		else if(r==N && c==N){
			cnt++;
			return;
		}
		// 아니라면, 8가지 방법으로 이동 
		else {
			// status : 1 - 가로 2 - 대각 3 - 세로
			// 현재 가로일 떄
			if(status==1) {
				// 오른쪽 이동
				if(arr[r][c+1] == 0) {
					search(r, c+1, 1);
				}
				// 대각 이동
				if(arr[r][c+1] == 0 && arr[r+1][c] == 0 && arr[r+1][c+1] == 0) {
					search(r+1, c+1, 2);
				}
			}
			// 현재 대각일 때
			else if (status==2) {
				// 오른쪽 이동
				if(arr[r][c+1] == 0) {
					search(r, c+1, 1);
				}
				// 대각 이동
				if(arr[r][c+1] == 0 && arr[r+1][c] == 0 && arr[r+1][c+1] == 0) {
					search(r+1, c+1, 2);
				}
				// 아래로 이동
				if(arr[r+1][c] == 0) {
					search(r+1, c, 3);
				}
			}
			// 현재 세로일 때
			else {
				// 대각 이동
				if(arr[r][c+1] == 0 && arr[r+1][c] == 0 && arr[r+1][c+1] == 0) {
					search(r+1, c+1, 2);
				}
				// 아래로 이동
				if(arr[r+1][c] == 0) {
					search(r+1, c, 3);
				}
			}
		}
	}
}