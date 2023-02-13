import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int N = sc.nextInt(), sum=0;
			List<Integer> arr = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				if(j<5)arr.add(sc.nextInt());
				else {
					arr.remove(0);
					arr.add(sc.nextInt());
					int left = Math.max(arr.get(0), arr.get(1));
					int right = Math.max(arr.get(3),arr.get(4));
					if(arr.get(2) > Math.max(left, right)) {
						sum +=  arr.get(2) - Math.max(left, right);
					}
				}
				if(j==4) {
					int left = Math.max(arr.get(0), arr.get(1));
					int right = Math.max(arr.get(3),arr.get(4));
					if(arr.get(2) > Math.max(left, right)) {
						sum +=  arr.get(2) - Math.max(left, right);
					}
				}
			}
			System.out.printf("#%d %d\n",i+1,sum);
		}
	}
}
