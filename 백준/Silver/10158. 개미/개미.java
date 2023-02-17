import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int big_x = sc.nextInt(), big_y = sc.nextInt();
		int x = sc.nextInt(), y = sc.nextInt();
		int t = sc.nextInt();
		boolean flag = false, flag2 = false;

		for (int i = 0; i < t % (big_x*2); i++) {
			if(x==big_x) {
				flag=true;
			}
			else if (x==0) {
				flag=false;
			}
			if(flag) {
				x -=1;
			}
			else {
				x +=1;
			}
		}
		
		for (int i = 0; i < t % (big_y*2); i++) {
			if(y==big_y) {
				flag2=true;
			}
			else if (y==0) {
				flag2=false;
			}
			if(flag2) {
				y -=1;
			}
			else {
				y +=1;
			}
		}
		System.out.print(x+" "+y);
	}
}
