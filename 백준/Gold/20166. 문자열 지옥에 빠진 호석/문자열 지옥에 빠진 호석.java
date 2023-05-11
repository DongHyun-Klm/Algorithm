import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr;
	static int cnt, N, M;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		//중복제거라도 해보자
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < K; i++) {
			String s = br.readLine();
			char[] search = s.toCharArray();
			if(map.containsKey(s)) {
				sb.append(map.get(s)).append('\n');
				continue;
			}
			cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(arr[j][j2]==search[0]) {
						BT(j, j2, search, 1);
					}
				}
			}
			map.put(s, cnt);
			sb.append(cnt).append('\n');
		}
		System.out.print(sb.toString());
	}
	private static void BT(int r, int c, char[] search, int d) {
		if(d==search.length) {
			cnt++;
			return;
		}
		for (int k = 0; k < 8; k++) {
			int nr = r + dir[k][0];
			int nc = c + dir[k][1];
			if(nr==-1) nr=N-1; else if(nr==N) nr=0;
			if(nc==-1) nc=M-1; else if(nc==M) nc=0;
			if(arr[nr][nc]!=search[d]) continue;
			BT(nr, nc, search, d+1);
		}
		
	}
}