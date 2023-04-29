import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for (int i = N; i >= 0; i--) {
			for(int j=i; j<N;j++) sb.append(' ');
			for(int j=0; j<i;j++) sb.append('*');
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}
}