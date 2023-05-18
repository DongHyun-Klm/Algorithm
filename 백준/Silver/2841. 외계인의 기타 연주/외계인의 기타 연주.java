import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer>[] q = new PriorityQueue[7];
		for(int i=1;i<=6;i++) q[i] = new PriorityQueue<>(Collections.reverseOrder());
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int sound = Integer.parseInt(st.nextToken());
			if(q[line].isEmpty()) {
				q[line].add(sound);
				ans++;
			}
			else {
				while (!q[line].isEmpty() && q[line].peek() > sound) {
					q[line].poll();
					ans++;
				}
				if(q[line].isEmpty()) {
					q[line].add(sound);
					ans++;
				}
				else if(q[line].peek() != sound) {
					q[line].add(sound);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
