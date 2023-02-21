import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] arr = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.substring(i, s.length());
		}
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (String string : arr) {
			System.out.println(string);
		}
	}
}
