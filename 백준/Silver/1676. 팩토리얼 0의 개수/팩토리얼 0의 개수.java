import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		sum += N/5;
		sum += N/25;
		sum += N/125;
		System.out.println(sum);
	}
}