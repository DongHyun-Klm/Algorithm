import java.util.*;

public class Main {
    static int N, K;
    static long ans = -1;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        input();
        // 1 2 3 4
        // 2 4 6 8
        // 3 6 9 12
        // 4 8 12 16

        // 1 2 2 3 3 4 4 4 6 6 8 8 9 12 12 16

        // K는 7이면
        // x보다 작거나 같은수가 7개인 x를 구하면 됨
        long L = 1, R = (long) N*N;
        while (L <= R) {
            long mid = (L + R) / 2, sum = 0;
            boolean can = true;
            for (int i = 1; i <= N; i++) {
                sum += Math.min(N, mid / i);
            }
            if(sum < K) can = false;
            if(can) {
                ans = mid;
                R = mid - 1;
            }
            else L = mid + 1;
        }
        System.out.println(ans);
    }

    private static void input() {
        N = sc.nextInt();
        K = sc.nextInt();
    }
}