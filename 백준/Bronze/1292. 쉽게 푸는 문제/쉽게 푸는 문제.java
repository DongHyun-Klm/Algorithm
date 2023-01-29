
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt(), sum = 0;
		List<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			for (int j = 0; j < i; j++) {
				arr.add(i);
			}
		}
		
		for (int i = N-1; i < K; i++) {
			sum += arr.get(i);
		}
		System.out.println(sum);
	}
}
