import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt(), ans = 0;
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = sc.nextInt();
		while (true) {
			int max = 0, max_index = 0;
			for(int i = 1;i<N;i++) {
				if(arr[i]>max) {
					max = arr[i];
					max_index = i;
				}
			}
			if(arr[0]>max) break;
			arr[max_index]--;
			arr[0]++;
			ans++;
		}
		System.out.println(ans);
	}
}