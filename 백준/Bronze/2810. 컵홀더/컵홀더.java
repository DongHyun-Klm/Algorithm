import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int hold = N+1;
		char[] arr = new char[N];
		arr = sc.next().toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 'L') {
				hold--;
				i++;
			}
		}
		if(hold>N)System.out.println(N);
		else System.out.println(hold);
	}
}
