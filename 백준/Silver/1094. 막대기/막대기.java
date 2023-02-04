import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int cnt = 0;
		while (true) {
			if(X%2==1)cnt++;
			X /= 2;
			if (X==0) break;
		}
		System.out.println(cnt);
	}
}