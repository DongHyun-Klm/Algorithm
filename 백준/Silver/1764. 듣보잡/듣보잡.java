import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for(int i=0; i<N; i++) set.add(br.readLine());
		ArrayList<String> ans = new ArrayList<>();
		int total = 0;
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			if(!set.contains(s)) continue;
				total++;
				ans.add(s);
		}
		Collections.sort(ans);
		System.out.println(total);
		for(String r : ans) {
			System.out.println(r);
		}
	}
}