import java.util.*;

public class Main {
	static int N, M;
	static int[] c;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt(); M = sc.nextInt();
		arr = new ArrayList[N+1];
		c = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			for (int j = 0; j < n-1; j++) {
				int y = sc.nextInt();
				arr[x].add(y);
				c[y]++;
				x = y;
			}
		}
		// 0인 애들 큐에 넣기
		for (int i = 1; i <c.length ; i++) {
			if(c[i]==0) {
				q.add(i);
				sb.append(i).append('\n');
			}
		}
		// 정렬 시작
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int y : arr[x]) {
				c[y]--;
				if(c[y]==0) {
					q.add(y);
					sb.append(y).append('\n');
				}
			}
		}
		boolean flag = false;
		for (int i = 1; i < c.length; i++) {
			if(c[i]!=0) {
				flag = true;
				break;
			}
		}
		if(flag) System.out.println(0);
		else System.out.print(sb.toString());
	}
}