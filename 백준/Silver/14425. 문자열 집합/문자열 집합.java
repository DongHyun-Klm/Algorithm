import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt(), ans = 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) set.add(sc.next());
		for (int i = 0; i < M; i++) if(set.contains(sc.next())) ans++;
		System.out.println(ans);
	}
}