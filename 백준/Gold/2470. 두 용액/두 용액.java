import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int sum = Integer.MAX_VALUE;
		int point1 = 0, point2 = N-1, ans1 = -1, ans2 = -1;
		while (point1!=point2) {
			int temp = arr[point1] + arr[point2];
			sum = Math.min(Math.abs(temp), sum);
			if(sum == Math.abs(temp)) {
				ans1 = point1;
				ans2 = point2;
			}
			if(temp == 0) break;
			else if (temp > 0) {
				point2--;
			}
			else {
				point1++;
			}
		}
		System.out.println(arr[ans1] + " " + arr[ans2]);
	}
}