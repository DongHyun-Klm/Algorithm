import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int T = sc.nextInt();
			Queue<Integer> arr = new LinkedList<Integer>();
			for (int j = 0; j < 8; j++) {
				arr.add(sc.nextInt());
			}
			outer:while(true) {
			for (int j = 1; j <= 5; j++) {
				int sni = arr.poll()-j;
				if(sni>0) arr.add(sni);
				else {
					arr.add(0); 
					break outer;
				}
			}
			}
			System.out.print("#"+T+" ");
			for (Integer integer : arr) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}
}
