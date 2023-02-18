import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			// 딱지 입력 받기, 입력 개수 정해지지 않아서 arraylist 사용 > 알려 주는구나;;
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreElements()) {
				A.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreElements()) {
				B.add(Integer.parseInt(st.nextToken()));
			}
			// 카운트 배열로 세기
			int[] cnt_A = new int[5];
			int[] cnt_B = new int[5];
			//입력 개수 주는지 모르고 풀어서 그냥 j=1부터 카운트 배열 받기
			for (int j = 1; j < A.size(); j++) {
				cnt_A[A.get(j)]++;
			}
			for (int j = 1; j < B.size(); j++) {
				cnt_B[B.get(j)]++;
			}
			
			// 카운트 배열 비교
			for (int j = 4; j > 0; j--) {
				if(cnt_A[j]>cnt_B[j]) {
					System.out.println("A");
					break;
				}
				else if (cnt_A[j]<cnt_B[j]) {
					System.out.println("B");
					break;
				}
				if(j==1) {
					System.out.println("D");
				}
			}
			
		}
	}
}
