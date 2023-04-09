import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[][] arr = new char[5][15];
		for (int i = 0; i < 5; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < c.length; j++) {
				arr[i][j] = c[j];
			}
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(arr[j][i]!='\0')sb.append(arr[j][i]); 
			}
		}
		System.out.println(sb.toString());
	}
}