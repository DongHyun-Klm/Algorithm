import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		int N = sc.nextInt();
		String[][] arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().split("\\.");
		}
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i][1], map.getOrDefault(arr[i][1], 0) + 1);
		}
		String[] keys = map.keySet().toArray(new String[0]);
		Arrays.sort(keys, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (int i = 0; i < keys.length; i++) {
			System.out.print(keys[i]+" ");
			System.out.println(map.get(keys[i]));
		}
	}
}