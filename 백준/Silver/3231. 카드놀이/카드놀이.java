import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        int[] arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            int now = sc.nextInt();
            arr[now] = i+1;
        }
        for (int i = 1; i <= N; i++) {
            if(arr[i-1] > arr[i]) answer++;
        }
        System.out.println(answer);
    }
}