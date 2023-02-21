import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		// A 65 Z 90 a 97 z 122
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if (num >= 97) {
				num += 13;
				if (num > 122)
					num -= 26;
			} else if (num >= 65) {
				num += 13;
				if (num > 90)
					num -= 26;
			}
			sb.append((char) num);
		}
		System.out.println(sb.toString());
	}
}