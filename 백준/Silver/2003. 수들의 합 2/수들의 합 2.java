import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int point1 = 1, point2 = 1;
		while (point1<N+1) {
			int sum = 0;
			for (int i = point1; i <= point2; i++) {
				sum += arr[i];
			}
			if(sum == M)cnt++;
			if(point2==N) {point1++; continue;}
			if(point1 == point2) point2++;
			else if(sum > M) point1++;
			else point2++;
		}
		System.out.println(cnt);
	}
}