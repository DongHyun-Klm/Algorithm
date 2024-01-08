import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] kettle = new int[N];
        long L = 0, R = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < N; i++) {
            kettle[i] = sc.nextInt();
        }
        while (L <= R) {
            long mid = (L + R) / 2;
            if(mid == 0) break;
            long count = 0;
            boolean can = true;
            for (int i = 0; i < N; i++) {
                count += kettle[i] / mid;
            }
            if(K > count) can = false;
            if(!can) R = mid - 1;
            else {
                L = mid + 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}