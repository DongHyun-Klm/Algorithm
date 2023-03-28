import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String b = sc.next();
		String[] s = b.split("\\.");
		boolean flag = false;
		ArrayList<String> arr = new ArrayList<>();
		for (String string : s) {
			if (!string.equals(""))
				arr.add(string);
		}
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).length() % 2 == 1) {
				flag = true;
				break;
			}
			StringBuilder sb = new StringBuilder();
			if (arr.get(i).length() / 4 != 0) {
				for (int j = 0; j < arr.get(i).length() / 4; j++) {
					sb.append("AAAA");
				}
			}
			if ((arr.get(i).length() % 4) / 2 != 0)
				sb.append("BB");
			arr.set(i, sb.toString());
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals(""))
				sb.append('.');
			else {
				sb.append(arr.get(cnt++));
				if (i != s.length - 1)
					sb.append('.');
			}
		}
		char[] bb = b.toCharArray();
		int index = bb.length - 1;
		while (index>=0) {
			if(bb[index] != '.') break;
			sb.append('.');
			index--;
		}

		if (flag)
			System.out.println(-1);
		else {
			System.out.println(sb.toString());
		}
	}
}