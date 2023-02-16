import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] arr = s.toCharArray();
		int N = s.length(), R=0, C=0, cnt =0;
		for (int i = (int)Math.sqrt(N); i > 0; i--) {
			if(N%i==0) {
				R = i;
				C = N/i;
				break;
			}
		}
		
		while (true) {
			for (int i = 1; i <= C; i++) {
				System.out.print(arr[R*i-R+cnt]);
			}
			cnt++;
			if(cnt==R)break;
		}
		
	}
}