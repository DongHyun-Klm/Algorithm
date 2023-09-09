import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int[] dp = new int[arr.length];
        boolean can = true;
        if(arr[0] == '0') {
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        if(arr.length>=2) {
            if (arr[1] != '0') dp[1] = 1;
            if (Integer.parseInt(arr[0] + "" + arr[1]) < 27) dp[1] += 1;
        }
        for (int i = 2; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i-1] + "" + arr[i]);
            if(arr[i]!='0') dp[i] += dp[i-1];
            else if(num >= 30){
                can = false;
                break;
            }
            if(num<27 && num >9) {
                dp[i] += dp[i-2];
            }
            dp[i] %= 1000000;
        }
//        System.out.println(Arrays.toString(dp));
        if(can)System.out.println(dp[arr.length-1]);
        else System.out.println(0);
    }
}