import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n1 = sc.next(), n2 = sc.next(), n3 = sc.next(), n4 = sc.next();
		long number1 = 0, number2 = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(n1);
		sb.append(n2);
		char[] arr = sb.toString().toCharArray();
		for (int i = 0; i < arr.length; i++) {
			long a = (arr[i]-'0') * (long)Math.pow(10, arr.length-i-1);
			number1 += a;
		}
		sb.setLength(0);
		sb.append(n3);
		sb.append(n4);
		arr = sb.toString().toCharArray();
		for (int i = 0; i < arr.length; i++) {
			long a = (arr[i]-'0') * (long)Math.pow(10, arr.length-i-1);
			number2 += a;
		}
		System.out.println(number1+number2);
	}
}
