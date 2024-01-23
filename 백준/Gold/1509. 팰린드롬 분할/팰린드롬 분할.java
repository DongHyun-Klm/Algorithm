import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String s;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length]; // dp[x][y]는 x~y 구간의 팰린드롬 분할 최소값
        boolean[][] chk = new boolean[arr.length][arr.length]; // chk[x][y]는 x~y구간이 팰린드롬인지
        // 초기값
        for (int i = 0; i < arr.length; i++) {
            chk[i][i] = true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] != arr[i+1]) continue;
            chk[i][i+1] = true;
        }
        // chk 배열부터 구하기
        for (int len = 2; len < arr.length; len++) {
            for (int s = 0; s + len < arr.length; s++) {
                if(arr[s] != arr[s+len]) continue;
                chk[s][s+len] = chk[s+1][s+len-1];
            }
        }
        // dp 배열 구하기
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(chk[j][i]) {
                    if(j==0) dp[i] = 1;
                    else dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }
        System.out.println(dp[arr.length-1]);
    }

    private static void input() throws IOException {
        s = br.readLine();
    }
}