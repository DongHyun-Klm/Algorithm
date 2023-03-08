import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Double> map = new HashMap<>();
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		map.put("P", 0.0);
		double sum = 0, sum2 = 0;
		for (int i = 0; i < 20; i++) {
			sc.next();
			double num = sc.nextDouble();
			String s = sc.next();
			if (!s.equals("P")) {
				sum2 += num;
				sum += num * map.get(s);
			}
		}
		System.out.printf("%.6f",sum/sum2);
	}
}