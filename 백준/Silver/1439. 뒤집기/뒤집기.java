import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력 받기
		char[] arr = sc.next().toCharArray();
		
		//중복 제거하여 01 저장할 arraylist
		ArrayList<Boolean> chk = new ArrayList<>();
		
		//중복 제거하여 저장
		for (int i = 0; i < arr.length; i++) {
			if(i==0) {
				if(arr[i]=='0')chk.add(false);
				else chk.add(true);
			}
			else {
				if(arr[i]!=arr[i-1]) {
					if(arr[i]=='0')chk.add(false);
					else chk.add(true);
				}
			}
		}
		// 0과 1의 개수를 셀 카운트 배열
		int[] cnt = new int[2];
		for (boolean i : chk) {
			if(i==false)cnt[0]++;
			else cnt[1]++;
		}
		// 0과 1중 작은것이 최소 횟수
		System.out.println(Math.min(cnt[0], cnt[1]));
	}
}
