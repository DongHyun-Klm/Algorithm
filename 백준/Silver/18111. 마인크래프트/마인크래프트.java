import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
				B = Integer.parseInt(st.nextToken());
		int maxHeight, leastTime = Integer.MAX_VALUE, total=B,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		int[] arr = new int[257];
		int height=-1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[Integer.parseInt(st.nextToken())] += 1;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			total += arr[i]*i;
			if(arr[i]>0) {
				max = Math.max(max, i);
				min = Math.min(min, i);
			}
		}
		maxHeight = total/(N*M);
		if(maxHeight>max)maxHeight=max;

		
		while(maxHeight>=min) {
			int time = 0;
			for (int i = 0; i < maxHeight; i++) {
				time += (maxHeight-i)*arr[i];
			}
			for (int i = maxHeight+1; i<257; i++) {
				time += (i-maxHeight)*arr[i]*2;
			}
			
			if(leastTime>time) {
				leastTime = time;
				height = maxHeight;
			}
			maxHeight--;
		}
		
		System.out.printf("%d %d",leastTime,height);
	}

}

