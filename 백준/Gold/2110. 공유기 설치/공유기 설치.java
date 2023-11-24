import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] house;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for (int i = 0; i < house.length; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		int L = 0, R = house[N-1], ans = 0;
		while (L<=R) {
			int mid = (L + R) /2;
			if(can(mid, C)) {
				ans = mid;
				L = mid + 1;
			}
			else R = mid - 1;
		}
		System.out.println(ans);
	}
	// 거리가 d일 때 C개 이상의 공유기를 설치할 수 있는지 확인하는 메서드
	private static boolean can(int d, int C) {
		int cnt = 1, last = house[0];
		for (int i = 1; i < house.length; i++) {
			if(house[i]-last>=d) {
				cnt++;
				last = house[i];
			}
		}
		return cnt >= C;
	}
}