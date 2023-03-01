import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = N / 2, max = 0;
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> al_max = new ArrayList<>();
		while (start <= N) {
			al.clear();
			al.add(N);
			al.add(start);
			int index = 1;
			while (true) {
				if (al.get(index - 1) - al.get(index) >= 0) {
					al.add(al.get(index - 1) - al.get(index));
					index++;
				} else
					break;
			}
			max = Math.max(index + 1, max);
			if (max == index + 1)
				al_max = (ArrayList<Integer>) al.clone();
			start++;
		}
		System.out.println(max);
		System.out.println(al_max.toString().replaceAll("[\\[\\],]", ""));
	}
}