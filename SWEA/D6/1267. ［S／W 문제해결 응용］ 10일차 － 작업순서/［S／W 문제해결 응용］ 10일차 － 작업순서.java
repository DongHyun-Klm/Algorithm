import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();
			int V = sc.nextInt(); 
			int E = sc.nextInt();
			int[] degree = new int[V+1];
			ArrayList<Integer>[] arr = new ArrayList[V+1];
			for (int i = 1; i < arr.length; i++) {
				arr[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x].add(y);
				degree[y]++;
			}
			Queue<Integer> queue = new LinkedList<>();
			sb.append('#').append(tc).append(' ');
			// 진입 차수 0인 애들 큐에 넣기
			for (int i = 1; i<degree.length; i++) {
				if(degree[i] == 0) queue.add(i);
			}
			while (!queue.isEmpty()) {
				int index = queue.poll();
				sb.append(index).append(' ');
				for (int i = 0; i < arr[index].size(); i++) {
					degree[arr[index].get(i)]--;
					if(degree[arr[index].get(i)]==0) queue.add(arr[index].get(i));
				}
			}
			System.out.println(sb.toString());
		}
	}
}