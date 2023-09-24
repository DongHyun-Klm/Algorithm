
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) dp[1][i] = 1;
        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        while (T --> 0) {
            int n = sc.nextInt();
            long answer = 0;
            for (int i = 0; i < 10; i++) {
                answer += dp[n][i];
            }
            System.out.println(answer);
        }
    }
}
