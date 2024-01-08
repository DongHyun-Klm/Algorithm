import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] lamp = new int[M];
        for (int i = 0; i < M; i++) {
            lamp[i] = sc.nextInt();
        }
        int L = 0, R = N;
        while (L < R) {
            int mid = (L + R) / 2;
            // 더 좋은 방법 있을 듯 한데
            int last = 0;
            boolean can = true;
            for (int i = 0; i < M; i++) {
                if(lamp[i] - mid > last) can = false;
                last = lamp[i] + mid;
            }
            if(last < N) can = false;
            if(can) R = mid;
            else L = mid + 1;
        }
        System.out.println(R);
    }
}