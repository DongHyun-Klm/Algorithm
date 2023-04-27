import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] arr = new ArrayList[N+1];
			StringTokenizer st;
			for(int i=1; i<=N; i++) arr[i] = new ArrayList<>();
			for(int i=1; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				arr[y].add(x);
			}
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
			Queue<Integer> q = new LinkedList<>();
			while (!arr[n1].isEmpty()) {
				q.add(n1);
				n1 = arr[n1].get(0);
			}
			while (!arr[n2].isEmpty()) {
				if(q.contains(n2))break;
				n2 = arr[n2].get(0);
			}
			System.out.println(n2);
		}
	}
}