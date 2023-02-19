import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			int x1=sc.nextInt(), y1=sc.nextInt(), x2=sc.nextInt(), y2=sc.nextInt();
			int x_1=sc.nextInt(), y_1=sc.nextInt(), x_2=sc.nextInt(), y_2=sc.nextInt();
			
			// 공통부분 없는 거부터
			if((x_2<x1 || x_1>x2) || (y_2 < y1 || y_1 > y2))System.out.println("d");
			// 점인 경우 
			else if ((x_2==x1||x_1==x2) && (y_2==y1||y_1==y2))System.out.println("c");
			// 선분
			else if ((x_2==x1||x_1==x2)) {
				if(y_2<=y1 || y_1>=y2) {}
				else System.out.println("b");
			}
			else if ((y_2==y1||y_1==y2)) {
				if(x_2<=x1 || x_1>=x2) {}
				else System.out.println("b");
			}
			// 직사각형
			else {
				System.out.println("a");
			}
		}
	}
}
