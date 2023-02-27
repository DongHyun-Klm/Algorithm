import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stk_right = new Stack<>();
		Stack<Integer> stk_left = new Stack<>();
		// arr[n] = m : 좌표 n의 기둥의 높이 m
		int[] arr = new int[1001];
		// 최고 높이의 기둥의 높이와 그 기둥의 index를 저장할 변수 선언
		int max_index = -1, max_height = Integer.MIN_VALUE;
		// 높이, 위치, 최고 높이, 최고 높이 기둥의 위치 받기
		for (int i = 0; i < N; i++) {
			int index = sc.nextInt(), height = sc.nextInt();
			arr[index] = height;
			max_height = Math.max(height, max_height);
			if (height == max_height)
				max_index = index;
		}
		// 최고 높이 왼쪽 기둥들 stack 받기
		for (int i = max_index - 1; i > 0; i--) {
			if (arr[i] != 0)
				stk_left.add(i);
		}
		// 최고 높이 오른쪽 기둥들 stack 받기
		for (int i = max_index + 1; i < arr.length; i++) {
			if (arr[i] != 0)
				stk_right.add(i);
		}
		// 넓이 담을 변수
		int area_left = 0, area_right = 0;
		// 양쪽의 최고 높이 담을 변수
		int max_height_left = 0, max_height_right = 0;
		// 왼쪽에 막대 있는지 확인
		if (!stk_left.isEmpty()) {
			// 왼쪽 넓이 구하기
			for (int i = stk_left.peek(); i < max_index; i++) {
				// 해당 위치에 막대가 있을때 현재 최고 높이보다 크다면 갱신
				if (arr[i] != 0)
					max_height_left = Math.max(arr[stk_left.pop()], max_height_left);
				area_left += max_height_left;
			}
		}
		// 오른쪽에 막대 있는지 확인
		if (!stk_right.isEmpty()) {
			// 오른쪽 넓이 구하기
			for (int i = stk_right.peek(); i > max_index; i--) {
				// 해당 위치에 막대가 있을때 현재 최고 높이보다 크다면 갱신
				if (arr[i] != 0)
					max_height_right = Math.max(arr[stk_right.pop()], max_height_right);
				area_right += max_height_right;
			}
		}
		System.out.println(area_left + area_right + max_height);
	}
}
