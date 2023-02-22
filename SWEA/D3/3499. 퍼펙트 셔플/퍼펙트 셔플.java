import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			Queue arr = new Queue(N);
			// 만든 큐를 두번 사용할 방법이 생각이 안남
			Queue arr2 = new Queue(N);
			// N 홀수 처리
			if (N % 2 == 1) {
				// 1번 큐
				for (int j = 0; j < (N / 2) + 1; j++) {
					arr.enQueue(sc.next());
				}
				// 2번 큐
				for (int j = 0; j < N / 2; j++) {
					arr2.enQueue(sc.next());
				}
			} else {
				// 1번 큐
				for (int j = 0; j < N / 2; j++) {
					arr.enQueue(sc.next());
				}
				// 2번 큐
				for (int j = N / 2; j < N; j++) {
					arr2.enQueue(sc.next());
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + i + " ");
			// 1번 큐가 비어질때 까지 = 2번 큐 비어질때까지
			while (!arr.isEmpty()) {
				if (!arr.isEmpty())
					sb.append(arr.deQueue() + " ");
				// 홀수 때문에 조건 추가
				if (!arr2.isEmpty())
					sb.append(arr2.deQueue() + " ");
			}
			System.out.println(sb.toString());
		}
	}
}

class Queue {
	public String[] arr;
	public int front = -1, rear = -1;
	
	public Queue(int size) {
		this.arr = new String[size];
	}
	// enQueue : 삽입
	public void enQueue(String x) {
		if (isFull())
			System.out.println("Queue에 더이상 원소를 추가할 수 없습니다.");
		else {
			arr[++rear] = x;
		}
	}

	// deQueue : 삭제
	public String deQueue() {
		if (isEmpty()) {
			System.out.println("Queue가 비어있습니다.");
			return null;
		}
		return arr[++front];
	}

	// peek : 가장 첫번째 원소 확인
	public String peek() {
		if (isEmpty()) {
			System.out.println("Queue가 비어있습니다.");
			return null;
		} else
			return arr[front + 1];
	}

	// isEmpty : 큐가 비어있는지
	public boolean isEmpty() {
		return rear == front;
	}

	// isFull : 큐가 꽉차있는지(포화상태인지, 원소를 추가할 수 있는지)
	public boolean isFull() {
		return rear == arr.length - 1;
	}

	// size : 현재 큐의 원소의 개수
	public int size() {
		return rear - front;
	}

}