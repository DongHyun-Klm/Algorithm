import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		if(arr.length==1&&arr[0]=='0') {
			System.out.println(0);
			return;
		}
		StringBuilder sb = new StringBuilder();
		int top = arr.length-1;
		while (top>0) {
			int n = arr[top--]-'0';
			if(n%2==1)sb.append('1');
			else sb.append('0');
			if((n%4)/2==1)sb.append('1');
			else sb.append('0');
			if(n/4==1)sb.append('1');
			else sb.append('0');
		}
		// 0제거를 위해 따로 처리하자
		if(top==0) {
			int n = arr[0] - '0';
			if(n>=4) {
				if(n%2==1)sb.append('1');
				else sb.append('0');
				if((n%4)/2==1)sb.append('1');
				else sb.append('0');
				if(n/4==1)sb.append('1');
			}
			else if(n>=2) {
				if(n%2==1)sb.append('1');
				else sb.append('0');
				if(n/2==1)sb.append('1');
			}
			else {
				sb.append('1');
			}
		}
		System.out.println(sb.reverse().toString());
	}
}
