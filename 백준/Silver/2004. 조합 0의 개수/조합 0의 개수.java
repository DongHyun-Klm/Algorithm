import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int n_m = n - m;
		long five_multiple = 5, n_five = 0, m_five = 0, n_m_five = 0;
		long two_multiple = 2, n_two = 0, m_two = 0, n_m_two = 0;
		// n!의 5의 개수 구하기
		while (n >= five_multiple) {
			n_five += n / five_multiple;
			five_multiple *= 5;
		}

		// m!의 5의 개수 구하기
		five_multiple = 5;
		while (m >= five_multiple) {
			m_five += m / five_multiple;
			five_multiple *= 5;
		}

		// (n-m)!의 5의 개수 구하기
		five_multiple = 5;
		while (n_m >= five_multiple) {
			n_m_five += n_m / five_multiple;
			five_multiple *= 5;
		}

		// n!의 2의 개수 구하기
		while (n >= two_multiple) {
			n_two += n / two_multiple;
			two_multiple *= 2;
		}

		// m!의 2의 개수 구하기
		two_multiple = 2;
		while (m >= two_multiple) {
			m_two += m / two_multiple;
			two_multiple *= 2;
		}

		// (n-m)!의 2의 개수 구하기
		two_multiple = 2;
		while (n_m >= two_multiple) {
			n_m_two += (n_m) / two_multiple;
			two_multiple *= 2;
		}
		long five = n_five - m_five - n_m_five;
		long two = n_two - m_two - n_m_two;
		System.out.println(Math.min(five, two));
	}
}
