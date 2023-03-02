import java.util.Scanner;

public class Solution {
	static int[] heap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc +" ");
			int N = sc.nextInt();
			heap = new int[N+1];
			int index = 0;
			// 명령문 반복
			for (int i = 0; i < N; i++) {
				int order = sc.nextInt();
				switch (order) {
								case 1:
					// 일단 마지막에 넣고
					heap[++index] = sc.nextInt();
					// 부모랑 비교
					int cur1 = index ,cur2 = index/2;
					while (cur2 != 0) {
						// 내가 부모보다 크면 스왑
						if(heap[cur1] > heap[cur2]) {
							swap(cur1 , cur2);
						}
						// 아니면 중단
						else break;
						cur1 = cur2;
						cur2 /= 2;
					}
					break;

				case 2:
					if(index==0) {
						sb.append("-1 ");
						break;
					}
					sb.append(heap[1] + " ");
					heap[1] = heap[index--];
					// 자식과 비교
					int curr1 = 1, curr2 = 2;
					while (curr2<=index) {
						// 자식 둘일때 and 둘중에 하나라도 나보다 커야함
						if(curr2+1 <= index&&(heap[curr1]<heap[curr2] ||heap[curr1]<heap[curr2+1] )) {
							// 큰 놈으로 간다
							curr2 = heap[curr2] > heap[curr2+1] ? curr2 :curr2+1;
							// 큰놈이랑 스왑
							swap(curr2, curr1);
						}
						// 자식 하나라면 나보다 커야함
						else if(heap[curr1]<heap[curr2]) {
							swap(curr1, curr2);
						}
						// 다 아니라면 중단
						else break;
						curr1 = curr2;
						curr2 *= 2;
					}
					break;
				}
			}
			System.out.println(sb.toString());
		}
	}

	private static void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}