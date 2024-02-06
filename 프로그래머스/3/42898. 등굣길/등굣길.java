import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];
        // 웅덩이
        for(int i=0; i<puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }
        // 초기값
        for(int i=1; i<=m; i++) {
            if(dp[i][1]==-1) break;
            dp[i][1] = 1;
        }
        for(int i=1; i<=n; i++) {
            if(dp[1][i]==-1) break;
            dp[1][i] = 1;
        }
        
        // dp[m][n] 구하기
        for(int i=2; i<=n; i++) {
            for(int j=2; j<=m; j++) {
                if(dp[j][i] == -1) continue;
                dp[j][i] = dp[j-1][i] + dp[j][i-1];
                if(dp[j-1][i] == -1) dp[j][i]++;
                if(dp[j][i-1] == -1) dp[j][i]++;
                dp[j][i] %= 1000000007;
            }
        }
        answer = dp[m][n];
        return answer;
    }
}