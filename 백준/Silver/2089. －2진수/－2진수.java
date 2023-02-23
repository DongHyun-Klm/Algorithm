import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		if(N == 0)sb.append(0);
		else {
			while (N != 1) {
				if(N%2==0)sb.append(0);
				else sb.append(1);
				N = (int)Math.ceil((double)N/-2);
			}
			if(N==1)sb.append(1);
		}
		System.out.println(sb.reverse().toString());
	}
}
