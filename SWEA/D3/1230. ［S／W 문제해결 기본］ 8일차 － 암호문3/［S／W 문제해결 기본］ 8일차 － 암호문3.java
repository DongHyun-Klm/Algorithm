import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int N = sc.nextInt();
			SinglyLinkedList list = new SinglyLinkedList();
			for (int i = 0; i < N; i++) {
				list.addToEnd(sc.nextInt());
			}
			int M = sc.nextInt();
			for (int j = 0; j < M; j++) {
				String key = sc.next();
				switch (key) {
				// 삽입
				case "I":
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int k = 0; k < y; k++) {
						list.addIndex(x + k, sc.nextInt());
					}
					break;
				// 삭제
				case "D":
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					for (int k = 0; k < y1; k++) {
						list.deleteIndex(x1);
					}
					break;
				// 추가
				case "A":
					int y2 = Integer.parseInt(sc.next());
					for (int k = 0; k < y2; k++) {
						list.addToEnd(sc.nextInt());
					}
					break;
				}
			}
			System.out.print("#" + (tc + 1) + " ");
			list.printList();
			System.out.println();
		}
	}

	// 연결리스트를 만들기 위한 노드 객체
	static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// 연결리스트 객체
	static class SinglyLinkedList {
		Node head;

		// 가장 마지막에 추가 : addToEnd
		private void addToEnd(int data) {
			Node n = new Node(data);
			if (head == null)
				head = n;
			else {
				Node curr = head;
				while (curr.next != null) {
					curr = curr.next;
				}
				curr.next = n;
			}

		}

		// 가장 처음에 추가 : addToStart
		private void addToStart(int data) {
			Node n = new Node(data);
			n.next = head;
			head = n;
		}

		// 가장 처음에 있는 노드 삭제: deleteStart
		private void deleteStart() {
			Node curr = head;
			head = curr.next;
		}

		// 리스트를 순회해서 출력: printList, 이문제는 10개만
		public void printList() {
			Node curr = head;
			int cnt = 0;
			while (curr != null && cnt != 10) {
				System.out.print(curr.data + " ");
				curr = curr.next;
				cnt++;
			}
		}

		// 앞에서부터 x의 위치 바로 다음에 data를 가진 node삽입
		private void addIndex(int index, int data) {
			if (index == 0) {
				addToStart(data);
			} else {
				Node n = new Node(data);
				int cnt = 1;
				Node curr = head;
				while (curr != null && index != cnt) {
					curr = curr.next;
					cnt++;
				}
				n.next = curr.next;
				curr.next = n;
			}
		}

		// 앞에서부터 x의 위치 바로 다음 숫자를 삭제
		private void deleteIndex(int index) {
			if (index == 0) {
				deleteStart();
			} else {
				int cnt = 1;
				Node curr = head;
				while (curr != null && index != cnt) {
					curr = curr.next;
					cnt++;
				}
				Node next = curr.next;
				curr.next = next.next;
			}
		}
	}
}
