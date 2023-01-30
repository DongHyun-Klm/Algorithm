import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int m1 = 1, d1 = 1, m2 = sc.nextInt(), d2 = sc.nextInt();
		int day = 0;
		for (int j = 1; j < m2; j++) {
			day += arr[j];
		}
		day += d2;
		day = day%7;
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		System.out.println(week[day]);
	}
}
