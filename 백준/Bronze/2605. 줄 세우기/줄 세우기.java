import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(list.size() - sc.nextInt(), i);
		}
		System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
	}
}