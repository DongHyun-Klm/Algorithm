import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			arr.add(sc.nextInt());
		}
		arr.sort(Comparator.naturalOrder());

		int n1 = 0, n2 = 0;
		outer: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				int sum = 0;
				n1 = arr.get(i);
				n2 = arr.get(j);
				arr.remove(j);
				arr.remove(i);

				for (Integer integer : arr) {
					sum += integer;
				}
				if (sum == 100) {
					for (Integer integer : arr) {
						System.out.println(integer);
					}
					break outer;
				} else {
					arr.add(j - 1, n2);
					arr.add(i, n1);

				}
			}
		}

	}
}
