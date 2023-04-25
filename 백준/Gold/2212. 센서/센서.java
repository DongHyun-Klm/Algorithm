import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		int[] sensor = new int[N];
		int[] dif = new int[N-1];
		for (int i = 0; i < sensor.length; i++) 
			sensor[i] = sc.nextInt();
		Arrays.sort(sensor);
		for (int i = 0; i < dif.length; i++) 
			dif[i] = sensor[i+1] - sensor[i];
		Arrays.sort(dif);
		int ans = 0;
		for (int i = 0; i < dif.length-(K-1); i++) {
			ans += dif[i];
		}
		System.out.println(ans);
	}
}