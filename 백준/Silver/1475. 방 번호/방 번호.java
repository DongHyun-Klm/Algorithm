import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[10];
		char[] arr = sc.next().toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]-'0'==9) cnt[6]++;
			else cnt[arr[i]-'0']++;
		}
		cnt[6]++; cnt[6] /= 2;
		System.out.println(Arrays.stream(cnt).max().getAsInt());
	}
}