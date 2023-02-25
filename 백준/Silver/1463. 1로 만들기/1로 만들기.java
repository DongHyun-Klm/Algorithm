import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt(), cnt = 0;
		int[] N = new int[X+1];
		N[0] = 0;
		N[1] = 0;
		for (int i = 2; i < N.length; i++) {
			N[i] = N[i-1]+1;
			if(i%2==0) N[i] = Math.min(N[i], N[i/2]+1);
			if(i%3==0) N[i] = Math.min(N[i], N[i/3]+1);
		}
		System.out.println(N[X]);
	}
}
