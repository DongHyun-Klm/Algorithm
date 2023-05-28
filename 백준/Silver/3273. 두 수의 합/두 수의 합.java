import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int x = Integer.parseInt(br.readLine());
		int index = 1, point1 = 1, point2 = n, ans = 0;
		while (index < n) {
			point1 = index + 1;
			while (point1 <= point2) {
				int mid = (point1+point2)/2;
				if(arr[index] + arr[mid] == x) {
					ans++;
					break;
				}
				if(arr[index] + arr[mid] < x) point1 = mid + 1;
				else point2 = mid - 1;
			}
			index++;
		}
		System.out.println(ans);
	}
}