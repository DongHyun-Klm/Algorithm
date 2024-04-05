class Solution {
    public int solution(int[] money) {
        int answer = 0, size = money.length;
        // 처음 집을 털었냐 안털었냐 나누고 직선처럼 처리
        
        // 처음 집 턴경우
        
        // dp1[i]는 i번째 집을 털었을때 최대 돈
        int[] dp1 = new int[size];
        // dp2[i]는 i번째 집을 안 털었을때 최대 돈
        int[] dp2 = new int[size];
        dp1[0] = money[0];
        dp2[1] = money[0];
        
        for(int i=2; i<size; i++) {
            dp1[i] = Math.max(dp1[i-2] + money[i], dp2[i-1] + money[i]);
            dp2[i] = Math.max(dp1[i-1], dp2[i-1]);
        }
        
        answer = Math.max(dp1[size-2], dp2[size-1]);
        
        // 처음 집 안턴경우
        dp1 = new int[size];
        dp2 = new int[size];
        dp1[1] = money[1];
        dp1[2] = money[2];
        dp2[2] = money[1];
        
        for(int i=3; i<size; i++) {
            dp1[i] = Math.max(dp1[i-2] + money[i], dp2[i-1] + money[i]);
            dp2[i] = Math.max(dp1[i-1], dp2[i-1]);
        }
        
        answer = Math.max(answer, Math.max(dp1[size-1], dp2[size-1]));
        return answer;
    }
}