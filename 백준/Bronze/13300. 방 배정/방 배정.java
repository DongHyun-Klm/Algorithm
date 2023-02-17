import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		int[][] student = new int[2][6];
		int room = 0;
		for (int i = 0; i < N; i++) {
			student[sc.nextInt()][sc.nextInt()-1]++;
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if(student[i][j]!=0) {
					room += ((student[i][j]+(K-1))/K);
				}
			}
		}
		
		System.out.println(room);
	}
}
