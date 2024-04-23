import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] cnt = new int[1001];
        for(int i=0; i<weights.length; i++) {
            cnt[weights[i]]++;
        }
        
        for(int i=100; i<=1000; i++) {
            // 무게 같은경우
            answer += (long)cnt[i] * (cnt[i] - 1) / 2;
            // 3 : 2
            if(i % 2 == 0 && i * 3 / 2 <= 1000) answer += (long)cnt[i] * cnt[i * 3 / 2];
            // 4 : 2
            if(i * 2 <= 1000) answer += (long)cnt[i] * cnt[i*2];
            // 4 : 3
            if(i % 3 == 0 && i * 4 / 3 <= 1000) answer += (long)cnt[i] * cnt[i * 4 / 3];
        }
        
        return answer;
    }
}