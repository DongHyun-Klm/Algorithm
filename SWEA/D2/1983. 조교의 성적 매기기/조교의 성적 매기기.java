import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt(), K = sc.nextInt()-1;
			double[] arr = new double[N];
			for (int j = 0; j < N; j++) {
				double sum = 0;
				for (int j2 = 0; j2 < 3; j2++) {
					if(j2==0)sum += sc.nextInt() * 0.35;       //중간
					else if(j2==1)sum += sc.nextInt() * 0.45;  //기말
					else if(j2==2)sum += sc.nextInt() * 0.20;  //과제
					
				}
				arr[j] = sum;
			}
			double[] arr2 = Arrays.copyOf(arr, N);  //원본저장
			Arrays.sort(arr);
			int [] rank = new int[N];

			for (int j = 0; j < N; j++) {
				//rank에 순위 저장, 내림차순 만들려고 abs씀 
				rank[j] = Math.abs((Arrays.binarySearch(arr, arr2[j])-N));
			}
			System.out.printf("#%d ",i);
			System.out.println(grades[(rank[K]-1)/(N/10)]);
		}
	}
}
