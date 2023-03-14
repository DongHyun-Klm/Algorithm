import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong(), sum = 0, cnt = 1;
		while (S>=sum) {
			sum += cnt++;
		}
		System.out.println(cnt-2);
	}
}