import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char[] arr1 = sc.next().toCharArray(), arr2 = sc.next().toCharArray();
        int[][] dp = new int[arr1.length+1][arr2.length+1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if(arr1[i-1] != arr2[j-1]) dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                else dp[i][j] = dp[i-1][j-1] + 1;
            }
        }
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        int r = arr1.length, c = arr2.length;
        while (r >= 1 && c >= 1) {
            if(dp[r][c] == dp[r-1][c]) r--;
            else if(dp[r][c] == dp[r][c-1]) c--;
            else {
                sb.insert(0, arr1[r-1]);
                r--; c--;
            }
        }
        System.out.println(sb.length());
        System.out.println(sb);
    }
}
