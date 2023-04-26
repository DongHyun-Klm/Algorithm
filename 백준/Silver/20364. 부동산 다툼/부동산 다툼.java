import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N+1];
		for (int i = 0; i < Q; i++) {
			int x = Integer.parseInt(br.readLine());
			int temp = x;
			boolean flag = false;
			while (temp != 0) {
				if(visited[temp]) {
					flag = true;
					x = temp;
				}
				temp /= 2;
			}
			if(flag) sb.append(x).append('\n');
			else {
				visited[x] = true;
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}