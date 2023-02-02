import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
            double avg=0;
			ArrayList<Integer> arr = new ArrayList<>();
			for (int j = 0; j < 10; j++) {
				arr.add(sc.nextInt());
			}
			Collections.sort(arr);
			arr.remove(9); arr.remove(0);
			for (int j = 0; j < arr.size(); j++) {
				avg += arr.get(j);
			}
			System.out.printf("#%d %.0f\n",i,avg/arr.size());
		}
	}
}
