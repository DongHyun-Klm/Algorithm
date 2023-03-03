import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> index = new ArrayList<>();
		int[] count = new int[10001];
		for (int i = 0; i < n; i++) {
			count[sc.nextInt()]++;
		}
		for (int i = 1; i < count.length; i++) {
			if(count[i]!=0) index.add(i);
		}
		int[] sum = new int[index.size()];
		for (int i = 0; i < index.size(); i++) {
			// i보다 작은애
			for (int j = 0; j < i; j++) {
				sum[i] += (index.get(i) - index.get(j)) * count[index.get(j)];
			}
			// i보다 큰애
			for (int j = i+1; j < index.size(); j++) {
				sum[i] += (index.get(j) - index.get(i)) * count[index.get(j)];
			}
		}
		for (int i = 0; i < sum.length; i++) {
			if(sum[i] == Arrays.stream(sum).min().getAsInt()) {
				System.out.println(index.get(i));
				break;
			}
		}
	}
}