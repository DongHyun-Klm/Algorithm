import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		sort[] arr = new sort[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new sort();
			arr[i].name = sc.next();
			arr[i].korean = sc.nextInt();
			arr[i].english = sc.nextInt();
			arr[i].math = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i].name);
		}
	}
	
	static class sort implements Comparable<sort>{
		public String name;
		public int korean, english, math;
		@Override
		public int compareTo(sort o) {
			if(korean != o.korean) return o.korean - korean;
			else if(english != o.english) return english - o.english;
			else if(math != o.math) return o.math - math;
			else return name.compareTo(o.name);
		}
	}
}