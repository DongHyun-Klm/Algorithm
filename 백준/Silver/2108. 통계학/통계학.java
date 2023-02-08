import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		double san = 0;
		for (int j : arr) {
			san += j;
		}
		System.out.printf("%d\n", Math.round(san / N));
		System.out.println(arr[N/2]);
		System.out.println(mostCommonNum(arr));
		System.out.println(arr[N-1]-arr[0]);
	}
	
	public static int mostCommonNum(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			if(map.containsKey(i))
			map.put(i, map.get(i)+1);
			else map.put(i, 1);
		}
		
		int max = Integer.MIN_VALUE;
		for (Integer i : map.values()) {
			max = max > i ? max : i;
		}
		
		List<Integer> keylist = new ArrayList<>(map.keySet());
		Collections.sort(keylist);
		int cnt =0, first=0;
		for (Integer i : keylist) {
			
			if(map.get(i) == max) {
				first = i;
				cnt++;
			}
			if (cnt ==2) return i;
			
		}
		return first;
	}
}