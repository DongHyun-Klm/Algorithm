class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        for(int i=0; i<triangle.length; i++) {
            dp[i] = new int[i+1];
        }
        // 초기값
        dp[0][0] = triangle[0][0];
        // 최대값 구하기
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<=i; j++) {
                for(int t : new int[] {j, j-1}) {
                    if(t < 0 || t > i-1) continue;
                    dp[i][j] = Math.max(dp[i-1][t] + triangle[i][j], dp[i][j]); 
                }
            }
        }
        
        for(int i=0; i<triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }
        return answer;
    }
}