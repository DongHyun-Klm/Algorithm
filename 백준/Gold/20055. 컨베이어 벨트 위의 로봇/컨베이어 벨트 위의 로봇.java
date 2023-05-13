import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> Dur = new ArrayList<>();
		boolean[] belt = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) Dur.add(Integer.parseInt(st.nextToken()));
		int ans = 0;
		int cnt = 0;
		while (true) {
			ans++;
			// 1
			Dur.add(0, Dur.get(Dur.size()-1));
			Dur.remove(Dur.size()-1);
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
					if(Dur.get(i+1)==0) cnt++;
					belt[i] = false;
				}
			}
			// 3
			if(Dur.get(0)!=0) {
				belt[0] = true;
				Dur.set(0,Dur.get(0)-1);
				if(Dur.get(0)==0) cnt++;
			}
			// 4
			if(cnt>=K) break;
		}
		System.out.println(ans);
	}
}