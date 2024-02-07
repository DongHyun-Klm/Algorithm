class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] learn = new boolean[n+1];
        boolean[] reser = new boolean[n+1];
        
        for(int i=0; i<lost.length; i++) {
            learn[lost[i]] = true; // true가 수업 못듣는애들
        }
        
        for(int i=0; i<reserve.length; i++) {
            if(learn[reserve[i]]) {
                learn[reserve[i]] = false;
            }
            else reser[reserve[i]] = true; // true가 빌려줄 수 있는 애들
        }
        
        
        for(int i=1; i<=n; i++) {
            if(learn[i]) {
                if(reser[i-1]) {
                    reser[i-1] = false;
                    answer++;
                }
                else if(i+1 <= n && reser[i+1]) {
                    reser[i+1] = false;
                    answer++;
                }
            }
            else answer++;
        }
        return answer;
    }
}