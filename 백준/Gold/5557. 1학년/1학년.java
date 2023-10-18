import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N + 1];
        for (int i = 0; i < N; i++) numbers[i+1] = sc.nextInt();
        long[][] dp = new long[N+1][21];
        dp[1][numbers[1]] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if(dp[i-1][j]!=0) {
                    if(j+numbers[i] <= 20)dp[i][j+numbers[i]] += dp[i-1][j];
                    if(j-numbers[i] >= 0)dp[i][j-numbers[i]] += dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N-1][numbers[N]]);
    }
}