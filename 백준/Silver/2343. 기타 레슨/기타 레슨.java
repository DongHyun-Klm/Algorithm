import java.util.Scanner;

public class Main {
    static int[] blueRays;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        blueRays = new int[N];
        int sum = 0, min = 0;
        for (int i = 0; i < N; i++) {
            blueRays[i] = sc.nextInt();
            min = Math.max(min, blueRays[i]);
            sum += blueRays[i];
        }
        while (min <= sum) {
            int mid = (min + sum) / 2;
            if (can(mid)) {
                sum = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    static private boolean can(int mid) {
        int temp = 0, cnt = 0;
        for (int i = 0; i < blueRays.length; i++) {
            if (temp + blueRays[i] > mid) {
                temp = blueRays[i];
                cnt++;
            } else {
                temp += blueRays[i];
            }
        }
        if(cnt<M) return true;
        else return false;
    }
}