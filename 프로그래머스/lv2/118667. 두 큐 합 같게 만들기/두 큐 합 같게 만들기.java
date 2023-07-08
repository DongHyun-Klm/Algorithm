import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        // // 합이 홀수면 불가능
        // if((sum1 + sum2) % 2 != 0) return -1;
        
        long target = (sum1 + sum2) / 2;
        while(sum1 != target){
            if(sum1 > target){
                int temp = q1.poll();
                sum1 -= temp;
                q2.add(temp);
                answer++;
            }
            else if(sum1 < target){
                int temp = q2.poll();
                sum1 += temp;
                q1.add(temp);
                answer++;
            }
            if(answer == (queue1.length + queue2.length)*2){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}