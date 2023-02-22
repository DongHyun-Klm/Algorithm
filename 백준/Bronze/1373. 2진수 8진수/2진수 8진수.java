import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		StringBuilder sb = new StringBuilder();
		// 뒤부터 긁어오자
		int top = arr.length-1;
		// 3개씩 sb에 추가
		while (true) {
			int eight = 0;
			eight += arr[top--] -'0';
			if(top<0) {
				sb.append(eight);
				break;
			}
			eight += 2*(arr[top--] -'0');
			if(top<0) {
				sb.append(eight);
				break;
			}
			eight += 4*(arr[top--] -'0');
			sb.append(eight);
			if(top<0)break;
		}
		// 출력은 거꾸로
		System.out.println(sb.reverse().toString());
	}
}
