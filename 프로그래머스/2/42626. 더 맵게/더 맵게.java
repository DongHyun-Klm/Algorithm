import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        for(int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }
        while(pq.size() > 1 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll() * 2;
            pq.add(a+b);
            answer++;
        }
        if(pq.peek() < K) answer = -1;
        return answer;
    }
}