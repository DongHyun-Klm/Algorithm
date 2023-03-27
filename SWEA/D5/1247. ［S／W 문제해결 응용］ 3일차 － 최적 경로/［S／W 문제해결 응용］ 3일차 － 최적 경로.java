import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int[] select;
	static boolean[] chk;
	static int N, min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+2][2];
			select = new int[N+2];
			chk = new boolean[N];
			min = Integer.MAX_VALUE;
			// select[0] - 집의 arr배열 좌표는 0, select[1] - 회사의 arr배열 좌표는 1
			select[0] = 0; select[N+1] = 1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < 2; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visit(1, 0);
			sb.append('#').append(tc+1).append(' ').append(min).append('\n');
		}
		System.out.println(sb.toString());
	}
	private static void visit(int d, int sum) {
		// 더하다가 지금 최소값보다 커지면 끝내기
		if(sum >= min) return;
		// 회사까지 도착했다면 min과 비교해서 최소값 저장
		if(d==N+1) {
			sum += Math.abs(arr[select[N]][0] - arr[select[N+1]][0]) + Math.abs(arr[select[N]][1] - arr[select[N+1]][1]);
			min = Math.min(sum, min);
		}
		// 순열로 다음 갈 집 정하기
		else {
			for (int i = 2; i <= N+1; i++) {
				if(chk[i-2]) continue;
				select[d] = i;
				chk[i-2] = true;
				visit(d+1, sum + Math.abs(arr[select[d-1]][0] - arr[select[d]][0]) + Math.abs(arr[select[d-1]][1] - arr[select[d]][1]));
				chk[i-2] = false;
			}
		}
	}
}