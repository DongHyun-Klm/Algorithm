import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		elem[] arr = new elem[N];
		int[] P = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new elem();
			arr[i].num = sc.nextInt();
			arr[i].idx = i;
		}
		Arrays.sort(arr);
		for (int i = 0; i < P.length; i++) {
			P[arr[i].idx] = i;
		}
		System.out.println(Arrays.toString(P).replaceAll("[\\[\\],]", ""));
	}
	static class elem implements Comparable<elem>{
		int num;
		int idx;
		@Override
		public int compareTo(elem o) {
			if(num!=o.num) return num-o.num;
			else return idx - o.idx;
		}
		
	}
}