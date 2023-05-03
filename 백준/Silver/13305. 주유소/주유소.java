import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] dis = new int[N-1];
		int[] city = new int[N];
		for(int i=0;i<N-1;i++) dis[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) city[i] = Integer.parseInt(st.nextToken());
		int point1 = 0, point2 = 1;
		long ans = 0;
		while (point1!=N-1) {
			int distance = dis[point1];
			while (point2!=N-1&&city[point2]>=city[point1]) {
				distance += dis[point2];
				point2++;
			}
			ans += distance * city[point1];
			point1 = point2;
			point2++;
		}
		System.out.println(ans);
	}
}