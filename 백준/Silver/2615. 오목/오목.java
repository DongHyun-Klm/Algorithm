import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[21][21];
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[] dr = {1,1,0,-1};
		int[] ds = {0,1,1,1};
		boolean flag = false;
		int omok = 0,r=0,c=0;
		
		outer:
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if(arr[i][j]!=0) {
					for (int j2 = 0; j2 < 4; j2++) {
						if(arr[i-dr[j2]][j-ds[j2]]!=arr[i][j]&&arr[i+dr[j2]][j+ds[j2]]==arr[i][j]
								&&arr[i+2*dr[j2]][j+2*ds[j2]]==arr[i][j]
										&&arr[i+3*dr[j2]][j+3*ds[j2]]==arr[i][j]
												&&arr[i+4*dr[j2]][j+4*ds[j2]]==arr[i][j]
														&&arr[i+5*dr[j2]][j+5*ds[j2]]!=arr[i][j]) {
							flag=true;
							omok=arr[i][j];
							r=i;
							c=j;
							break outer;
						}
							
					}
				}
			}
		}
		if(flag) {
			System.out.println(omok);
			System.out.printf("%d %d",r,c);
		}
		else {
			System.out.println(omok);
		}
	}
}
