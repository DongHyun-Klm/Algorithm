import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			int N2 = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N2; j++) {
				String key = st.nextToken();
				switch (key) {
				case "I":
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y; k++) {
						arr.add(x+k, Integer.parseInt(st.nextToken()));
					}
					break;
				case "D":
					int x1 = Integer.parseInt(st.nextToken());
					int y1 = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y1; k++) {
						arr.remove(x1);
					}
					break;
				case "A":
					int y2 = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y2; k++) {
						arr.add(Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			System.out.print("#"+(i+1)+" ");
			for (int j = 0; j < 10; j++) {
				System.out.print(arr.get(j)+" ");
			}
			System.out.println();
			
		}

	}
}
