import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        int point1, point2, point3;
        int[] answer = new int[3];
        for (int i = 0; i < N-2; i++) {
            point1 = i;
            point2 = i+1;
            point3 = N-1;
            long now = arr[point1];
            while (point2!=point3){
                long sum = now + arr[point2] + arr[point3];
                if(Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer[0] = arr[point1];
                    answer[1] = arr[point2];
                    answer[2] = arr[point3];
//                    System.out.println("sum = " + sum);
//                    System.out.println("point1 = " + point1 + " point2 = " + point2 + " point3 = " + point3);
                }
                if(sum == 0) break;
                else if(sum > 0) point3--;
                else point2++;
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}