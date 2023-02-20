import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		// 97 122
		int[] cnt = new int[122-97+1];
		for (int i = 0; i < arr.length; i++) {
			cnt[(int)arr[i]-97]++;
		}
		System.out.println(Arrays.toString(cnt).replaceAll("[\\[\\],]", ""));
	}
}
