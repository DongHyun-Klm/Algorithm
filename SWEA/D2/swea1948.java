import java.util.Scanner;

public class swea1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int T =sc.nextInt(), c1, c2=0;
		for (int i = 1; i <= T; i++) {
			int m1=sc.nextInt(),d1=sc.nextInt(),m2=sc.nextInt(),d2=sc.nextInt();
			int day = 0;
			for (int j = m1; j < m2; j++) {
				day += arr[j]; 
			}
			day =day-d1+d2+1;
			System.out.println("#"+i+" "+day);
		}
	}
}
