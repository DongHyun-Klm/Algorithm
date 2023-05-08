import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if(find(0,N-1,Integer.parseInt(st.nextToken()), arr)) sb.append(1).append(' ');
			else sb.append(0).append(' ');
		}
		System.out.print(sb.toString());
	}

	private static boolean find(int start, int end, int f, int[] arr) {
		while (start<=end) {
			int mid = (start + end) / 2;
			if(arr[mid]==f) return true;
			else if(arr[mid]>f) end = mid - 1;
			else start = mid + 1;
		}
		return false;
	}


}