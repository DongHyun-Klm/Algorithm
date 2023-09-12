import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), S = sc.nextInt(), min = Integer.MAX_VALUE, sum = 0;
        int[] arr = new int[N];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            q.add(arr[i]);
            while(sum >= S) {
                min = Math.min(q.size(), min);
                sum -= q.poll();
            }
        }
        System.out.println(min != Integer.MAX_VALUE ? min : 0);
    }
}