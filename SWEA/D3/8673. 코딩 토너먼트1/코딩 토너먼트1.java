import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int K = sc.nextInt();
			ArrayList<Integer> arl = new ArrayList<>();
			sum = 0;

			for (int j = 0; j < (int) Math.pow(2, K); j++) {
				arl.add(sc.nextInt());
			}

			while (arl.size() != 1) {
				for (int j = 0; j < arl.size() / 2; j++) {
					tournament(arl.get(2 * j), arl.get(2 * j + 1));
				} 
				int size = arl.size();
				for (int j = 0; j < size / 2; j++) {
					if (arl.get(j) > arl.get(j + 1)) {
						arl.remove(j + 1);
					} else {
						arl.remove(j);
					}
				}
			}
			System.out.printf("#%d %d\n",i+1,sum);
		}
	}

	public static void tournament(int a, int b) {
		sum += Math.max(a, b) - Math.min(a, b);
	}
}
