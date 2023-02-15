import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int sum=0, i = 0;
		while(i<10) {
			if(sum<100) {
			sum += arr[i++];
			}
			else break;
		}
		int num = sum - arr[i-1];
		
		if(sum-100 <= Math.abs(num-100))System.out.println(sum);
		else System.out.println(num);
	}
}
