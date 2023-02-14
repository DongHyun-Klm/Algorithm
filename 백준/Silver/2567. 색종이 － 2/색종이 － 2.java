import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[102][102];
		int N = sc.nextInt(), dulre = 0;
		for (int i = 0; i < N; i++) {
			int A = sc.nextInt(), B = sc.nextInt();
		
			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < 10; j2++) {
					arr[A+j+1][B+j2+1] = 1;
				}
			}
		}
	
			for (int j = 1; j <= 100; j++) {
				for (int j2 = 2; j2 <= 100; j2++) {
					if(arr[j][j2]==1) {
						if(arr[j+1][j2]==0)dulre++;
						if(arr[j][j2+1]==0)dulre++;
						if(arr[j-1][j2]==0)dulre++;
						if(arr[j][j2-1]==0)dulre++;
					}
				}
			}
			
		
		System.out.println(dulre);
	}
}
