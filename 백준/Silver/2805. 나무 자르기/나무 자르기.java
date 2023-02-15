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
		int max = Integer.MIN_VALUE;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		System.out.println(namu(0,max,M,arr));

	}
	
	public static long namu(int start, int end, int M, int[] arr) {
		if(start>end) return end;
		int mid = (start+end)/2;
		long sum = 0;
		for (int i : arr) {
			if(i>mid)sum +=i-mid;
		}
		if(sum>=M) return namu(mid+1, end, M, arr);
		else return namu(start, mid-1, M, arr);
	}
}
