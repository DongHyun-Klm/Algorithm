import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> s = new Stack<>();
        for(int i=0; i<prices.length; i++) {
            int cnt = 1;
            while(!s.isEmpty()) {
                if(s.peek()[1] > prices[i]) {
                    int[] now = s.pop();
                    answer[now[0]] = i - now[0];
                }
                else break;
            }
            s.add(new int[] {i, prices[i]});
        }
        while(!s.isEmpty()) {
                int[] now = s.pop();
                answer[now[0]] = prices.length - now[0] - 1;
        }
        return answer;
    }
}