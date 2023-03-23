import java.util.Scanner;

public class Solution {
	static int[] q;
	static boolean[] chk;
	static int cnt, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			q = new int[N+1]; chk = new boolean[N+1];
			cnt = 0;
			queen(1);
			System.out.printf("#%d %d\n",tc,cnt);
		}
	}
	// 두 퀸이 공격하지 못하게 놓는 경우의 수를 찾는 메서드
	private static void queen(int d) {
		// 퀸을 모두 놓았고, 공격 불가능한지 확인
		if(d == N+1) {
			// 공격이 불가능하다면 cnt++
			if(!can(N)) cnt++;
			return;
		}
		
		// 퀸을 놓자
		else {
			// q[1] = 1 이라면 1번째 줄의 퀸의 위치는 1
			for (int i = 1; i <= N; i++) {
				// 재귀 보내기 전에, 이미 공격 불가능하다면 거기서 끝내기
				if(can(d-1)) continue;
				// 이미 i번쨰 열에 퀸이 있다면 넘어가기
				if(chk[i]) continue;
				q[d] = i;
				chk[i] = true;
				queen(d+1);
				q[d] = 0;
				chk[i] = false;
			}
		}
	}
	
	// 퀸들이 공격이 가능한지 확인하는 메서드
	private static boolean can(int d) {
		// 첫 번째 줄부터 마지막 줄 전까지 퀸 확인 
		for (int i = 1; i < d; i++) {
			// 확인하려는 퀸 아래줄부터 마지막 줄 까지
			for (int j = i+1; j <= d; j++) {
				// 오른쪽 아래 대각선에 퀸이 있는지 확인, 있다면 true 리턴
				if(i - q[i] == j - q[j]) return true;
				// 왼쪽 아래 대각선에 퀸이 있는지 확인, 있다면 true 리턴
				if(i + q[i] == j + q[j]) return true;
			}
		}
		// 전부 통과했다면 공격 가능
		return false;
	}
}