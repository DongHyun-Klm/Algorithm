import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), sum = 0, max = 0;
        int[] asset = new int[N];
        for(int i=0; i<N; i++) {
            asset[i] = sc.nextInt();
            sum += asset[i];
            max = Math.max(asset[i], max);
        }
        int total = sc.nextInt();
        int min = total / N;
        if(total >= sum) {
            System.out.println(max);
            return;
        }
        Arrays.sort(asset);
        while (min <= max){
            int mid = (min+max)/2;
            int temp = 0;
            for(int i=0; i<N; i++) {
                if(asset[i] > mid) temp += mid;
                else temp += asset[i];
            }
            if(temp > total) max = mid - 1;
            else min = mid + 1;
        }
        System.out.println(max);
    }
}