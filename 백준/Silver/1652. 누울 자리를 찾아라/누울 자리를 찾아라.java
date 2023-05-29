import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][N];
		for (int i = 0; i < arr.length; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = temp[j];
			}
		}
		int ans_x = 0, ans_y = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = 0;
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]!='.') temp = 0;
				else temp++;
				if(temp==2) {
					ans_x++;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int temp = 0;
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][i]!='.') temp = 0;
				else temp++;
				if(temp==2) {
					ans_y++;
				}
			}
		}
		System.out.println(ans_x + " " + ans_y);
	}
}