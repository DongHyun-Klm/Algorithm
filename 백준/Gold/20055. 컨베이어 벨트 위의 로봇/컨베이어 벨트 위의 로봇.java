import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		LinkedList<Integer> Dur = new LinkedList<>();
		boolean[] belt = new boolean[N];
		for(int i=0;i<2*N;i++) Dur.add(sc.nextInt());
		int ans = 0;
		while (true) {
			ans++;
			// 1
			Dur.addFirst(Dur.getLast());
			Dur.removeLast();
			for(int i=N-2;i>=0;i--) {
				if(belt[i]) {
					belt[i+1] = true;
					belt[i] = false;
				}
			}
			if(belt[N-1]) belt[N-1] = false;
			// 2
			for(int i=N-2;i>=0;i--) {
				if(belt[i]) {
					if(belt[i+1])continue;
					if(Dur.get(i+1)==0)continue;
					belt[i+1] = true;
					Dur.set(i+1,Dur.get(i+1)-1);
					belt[i] = false;
				}
			}
			// 3
			if(Dur.get(0)!=0) {
				belt[0] = true;
				Dur.set(0,Dur.get(0)-1);
			}
			// 4
			int cnt = 0;
			for(int t : Dur) {
				if(t==0) cnt++;
			}
			if(cnt>=K) break;
		}
		System.out.println(ans);
	}
}