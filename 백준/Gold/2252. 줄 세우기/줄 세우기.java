import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); int M = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		int[] degree = new int[N+1];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x].add(y);
			degree[y]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		// 0인애들 큐에 넣기
		for (int i = 1; i < degree.length; i++) {
			if(degree[i] == 0) queue.add(i);
		}
		while (!queue.isEmpty()) {
			int index = queue.poll();
			sb.append(index).append(' ');
			for (int i = 0; i < arr[index].size(); i++) {
				degree[arr[index].get(i)]--;
				if(degree[arr[index].get(i)] == 0) queue.add(arr[index].get(i));
			}
		}
		System.out.println(sb.toString());
	}
}